package ke;

import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.n;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMediaLayerManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.AddCommentRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DoLikeRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.OverlayInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.UnLikeRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter.EditBatchMediaRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLike;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StRichMsg;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 72\u00020\u0001:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J,\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0004J\u001c\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00152\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fJ\u001c\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00152\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fJ\u001c\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00192\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000fR$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lke/d;", "Lcom/qzone/reborn/base/n;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "S1", "", "getLogTag", "commonFeed", "forwardFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "owner", "likeKey", "", "U1", "Lge/c;", "requestBean", "Lcom/qzone/reborn/base/n$a;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/EditBatchMediaRsp;", "dataCallback", "N1", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "T1", "Lge/e;", "Lge/d;", "O1", "P1", "Lge/b;", "Lge/a;", "M1", "i", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "getOwner", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "setOwner", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "getLikeKey", "()Ljava/lang/String;", "setLikeKey", "(Ljava/lang/String;)V", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "Q1", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "setCommonFeed", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;)V", "D", "R1", "setForwardFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneMediaLayerManager;", "E", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneMediaLayerManager;", "mediaLayerManager", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends n {

    /* renamed from: C, reason: from kotlin metadata */
    private CommonFeed commonFeed;

    /* renamed from: D, reason: from kotlin metadata */
    private CommonFeed forwardFeed;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CommonUser owner;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String likeKey = "";

    /* renamed from: E, reason: from kotlin metadata */
    private QzoneMediaLayerManager mediaLayerManager = new QzoneMediaLayerManager();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"ke/d$b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/AddCommentRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "rsp", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements DataCallback<AddCommentRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a<ge.a> f412070a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ge.b f412071b;

        b(n.a<ge.a> aVar, ge.b bVar) {
            this.f412070a = aVar;
            this.f412071b = bVar;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(AddCommentRsp rsp, long retCode, String msg2, boolean isFinish) {
            String str;
            List<StRichMsg> list;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            StComment stComment = rsp.comment;
            ge.a aVar = new ge.a(1);
            ge.b bVar = this.f412071b;
            if (stComment == null || (list = stComment.content) == null || (str = je.a.P(list)) == null) {
                str = "";
            }
            aVar.c(str);
            aVar.d(bVar.getCommentNum());
            aVar.e(bVar.getLLoc());
            this.f412070a.onSuccess(aVar, retCode, msg2, isFinish);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            this.f412070a.onFailure(errorCode, errorMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"ke/d$c", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/EditBatchMediaRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements DataCallback<EditBatchMediaRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a<EditBatchMediaRsp> f412072a;

        c(n.a<EditBatchMediaRsp> aVar) {
            this.f412072a = aVar;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(EditBatchMediaRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.f412072a.onSuccess(t16, retCode, msg2, isFinish);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            this.f412072a.onFailure(errorCode, errorMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"ke/d$d", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/DoLikeRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "rsp", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ke.d$d, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10651d implements DataCallback<DoLikeRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a<ge.d> f412073a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ge.e f412074b;

        C10651d(n.a<ge.d> aVar, ge.e eVar) {
            this.f412073a = aVar;
            this.f412074b = eVar;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(DoLikeRsp rsp, long retCode, String msg2, boolean isFinish) {
            String str;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ge.d dVar = new ge.d();
            ge.e eVar = this.f412074b;
            OverlayInfo overlayInfo = eVar.getOverlayInfo();
            if (overlayInfo == null || (str = overlayInfo.lloc) == null) {
                str = "";
            }
            dVar.g(str);
            dVar.d(eVar.getIsPraise());
            dVar.e(eVar.getPraiseNum());
            this.f412073a.onSuccess(dVar, retCode, msg2, isFinish);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            this.f412073a.onFailure(errorCode, errorMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"ke/d$e", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/UnLikeRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "rsp", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class e implements DataCallback<UnLikeRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a<ge.d> f412075a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ge.e f412076b;

        e(n.a<ge.d> aVar, ge.e eVar) {
            this.f412075a = aVar;
            this.f412076b = eVar;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(UnLikeRsp rsp, long retCode, String msg2, boolean isFinish) {
            String str;
            Integer num;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ge.d dVar = new ge.d();
            ge.e eVar = this.f412076b;
            OverlayInfo overlayInfo = eVar.getOverlayInfo();
            if (overlayInfo == null || (str = overlayInfo.lloc) == null) {
                str = "";
            }
            dVar.g(str);
            StLike stLike = rsp.like;
            boolean z16 = false;
            if (stLike != null && (num = stLike.status) != null && num.intValue() == 1) {
                z16 = true;
            }
            dVar.d(z16);
            dVar.e(eVar.getPraiseNum());
            this.f412075a.onSuccess(dVar, retCode, msg2, isFinish);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            this.f412075a.onFailure(errorCode, errorMsg);
        }
    }

    private final CommonFeed S1() {
        CommonFeed commonFeed = this.forwardFeed;
        return commonFeed != null ? commonFeed : this.commonFeed;
    }

    public final void M1(ge.b requestBean, n.a<ge.a> dataCallback) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        if (T1() == null || requestBean.getCommentComment() == null) {
            return;
        }
        QzoneMediaLayerManager qzoneMediaLayerManager = this.mediaLayerManager;
        CommonFeed S1 = S1();
        CommonUnionID T1 = T1();
        Intrinsics.checkNotNull(T1);
        CommonComment commentComment = requestBean.getCommentComment();
        Intrinsics.checkNotNull(commentComment);
        qzoneMediaLayerManager.addComment(S1, T1, commentComment, requestBean.getIsPrivate(), new OverlayInfo(requestBean.getLLoc()), Long.valueOf(requestBean.getBatchId()), new b(dataCallback, requestBean));
    }

    public final void N1(ge.c requestBean, n.a<EditBatchMediaRsp> dataCallback) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        this.mediaLayerManager.editBatchMedia(requestBean.getAlbumId(), requestBean.c(), requestBean.b(), new c(dataCallback));
    }

    public final void O1(ge.e requestBean, n.a<ge.d> dataCallback) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        if (T1() == null) {
            return;
        }
        QzoneMediaLayerManager qzoneMediaLayerManager = this.mediaLayerManager;
        CommonFeed S1 = S1();
        CommonUnionID T1 = T1();
        Intrinsics.checkNotNull(T1);
        qzoneMediaLayerManager.doLike(S1, T1, this.likeKey, requestBean.getOverlayInfo(), Long.valueOf(requestBean.getBatchId()), new C10651d(dataCallback, requestBean));
    }

    public final void P1(ge.e requestBean, n.a<ge.d> dataCallback) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        if (T1() == null) {
            return;
        }
        QzoneMediaLayerManager qzoneMediaLayerManager = this.mediaLayerManager;
        CommonFeed S1 = S1();
        CommonUnionID T1 = T1();
        Intrinsics.checkNotNull(T1);
        qzoneMediaLayerManager.unlike(S1, T1, this.likeKey, requestBean.getOverlayInfo(), Long.valueOf(requestBean.getBatchId()), new e(dataCallback, requestBean));
    }

    /* renamed from: Q1, reason: from getter */
    public final CommonFeed getCommonFeed() {
        return this.commonFeed;
    }

    /* renamed from: R1, reason: from getter */
    public final CommonFeed getForwardFeed() {
        return this.forwardFeed;
    }

    public final CommonUnionID T1() {
        CommonCellCommon cellCommon;
        CommonFeed S1 = S1();
        if (S1 == null || (cellCommon = S1.getCellCommon()) == null) {
            return null;
        }
        return cellCommon.getUnionId();
    }

    public final void U1(CommonFeed commonFeed, CommonFeed forwardFeed, CommonUser owner, String likeKey) {
        Intrinsics.checkNotNullParameter(likeKey, "likeKey");
        this.commonFeed = commonFeed;
        this.forwardFeed = forwardFeed;
        this.owner = owner;
        this.likeKey = likeKey;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFeedProLayerOperateViewModel";
    }
}
