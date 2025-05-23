package com.qzone.reborn.groupalbum.viewmodel;

import NS_MOBILE_OPERATION.MediaInfo;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellGroupAlbumInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.base.n;
import com.qzone.reborn.groupalbum.task.GroupAlbumPicCommentTask;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J&\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J6\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0015j\b\u0012\u0004\u0012\u00020\u0011`\u00162\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cJ \u0010\u001f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J,\u0010 \u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u0006J,\u0010!\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumCommentViewModel;", "Lcom/qzone/reborn/base/n;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "businessFeedData", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "fakeComment", "", "batch", "", "W1", "realComment", "Z1", "comment", "b2", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "reply", "c2", "", "getLogTag", "enable", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "commentPics", "R1", "isSuccess", "", QzoneIPCModule.RESULT_CODE, "", "opType", "X1", "T1", "S1", "U1", "Lki/j;", "i", "Lki/j;", "mCommentRepo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "show", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumCommentViewModel extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ki.j mCommentRepo = new ki.j();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean show;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/GroupAlbumCommentViewModel$b", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "t", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements n.a<Reply> {
        b() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Reply t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (GroupAlbumCommentViewModel.this.show) {
                com.qzone.reborn.util.o.f59556a.c(R.string.wbg, 2);
            }
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            com.qzone.reborn.util.o.f59556a.b(errorMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/GroupAlbumCommentViewModel$c", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "t", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements n.a<Comment> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f57008b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Comment f57009c;

        c(BusinessFeedData businessFeedData, Comment comment) {
            this.f57008b = businessFeedData;
            this.f57009c = comment;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Comment t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (GroupAlbumCommentViewModel.this.show) {
                com.qzone.reborn.util.o.f59556a.c(R.string.jmm, 2);
            }
            GroupAlbumCommentViewModel.this.b2(this.f57008b, this.f57009c);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            com.qzone.reborn.util.o.f59556a.b(errorMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/GroupAlbumCommentViewModel$d", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "t", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements n.a<Reply> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f57011b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Comment f57012c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Reply f57013d;

        d(BusinessFeedData businessFeedData, Comment comment, Reply reply) {
            this.f57011b = businessFeedData;
            this.f57012c = comment;
            this.f57013d = reply;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Reply t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (GroupAlbumCommentViewModel.this.show) {
                com.qzone.reborn.util.o.f59556a.c(R.string.jmm, 2);
            }
            GroupAlbumCommentViewModel.this.c2(this.f57011b, this.f57012c, this.f57013d);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            com.qzone.reborn.util.o.f59556a.b(errorMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/GroupAlbumCommentViewModel$e", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "realComment", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class e implements n.a<Comment> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comment f57014a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GroupAlbumCommentViewModel f57015b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f57016c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f57017d;

        e(Comment comment, GroupAlbumCommentViewModel groupAlbumCommentViewModel, BusinessFeedData businessFeedData, boolean z16) {
            this.f57014a = comment;
            this.f57015b = groupAlbumCommentViewModel;
            this.f57016c = businessFeedData;
            this.f57017d = z16;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Comment realComment, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNull(realComment);
            User user = realComment.user;
            Intrinsics.checkNotNull(user);
            if (TextUtils.isEmpty(user.nickName)) {
                realComment.user.nickName = this.f57014a.user.nickName;
            }
            this.f57015b.Z1(this.f57016c, realComment, this.f57014a);
            if (this.f57015b.show) {
                com.qzone.reborn.util.o.f59556a.c(R.string.jkq, 2);
            }
            this.f57015b.X1(this.f57017d, true, retCode, 0);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            com.qzone.reborn.util.o.f59556a.b(errorMsg);
            this.f57015b.X1(this.f57017d, false, errorCode, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W1(BusinessFeedData businessFeedData, Comment fakeComment, boolean batch) {
        this.mCommentRepo.e(batch, businessFeedData, fakeComment, new e(fakeComment, this, businessFeedData, batch));
    }

    public final void R1(final BusinessFeedData businessFeedData, final Comment fakeComment, ArrayList<String> commentPics, final boolean batch) {
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        Intrinsics.checkNotNullParameter(fakeComment, "fakeComment");
        Intrinsics.checkNotNullParameter(commentPics, "commentPics");
        if (commentPics.isEmpty()) {
            W1(businessFeedData, fakeComment, batch);
            return;
        }
        CellGroupAlbumInfo cellGroupAlbumInfo = businessFeedData.cellGroupAlbumInfo;
        String str = cellGroupAlbumInfo != null ? cellGroupAlbumInfo.groupId : null;
        String str2 = fakeComment.fakeUniKey;
        Intrinsics.checkNotNullExpressionValue(str2, "fakeComment.fakeUniKey");
        new GroupAlbumPicCommentTask(0, str, commentPics, str2, new Function1<MediaInfo, Unit>() { // from class: com.qzone.reborn.groupalbum.viewmodel.GroupAlbumCommentViewModel$addComment$task$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MediaInfo mediaInfo) {
                invoke2(mediaInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MediaInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                RFWLog.d("GroupAlbumCommentViewModel", RFWLog.USR, "upload success, do comment, pic size: " + it.picinfolist.size());
                Comment.this.commentPictureItems = ff.a.f398543a.f(it);
                this.W1(businessFeedData, Comment.this, batch);
            }
        }).addToTaskQueen();
    }

    public final void T1(BusinessFeedData businessFeedData, Comment comment, boolean batch) {
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        this.mCommentRepo.g(batch, businessFeedData, comment, new c(businessFeedData, comment));
    }

    public final void X1(boolean batch, boolean isSuccess, long resultCode, int opType) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("interact_op_success", Integer.valueOf(isSuccess ? 1 : 0));
        linkedHashMap.put("business_type", Integer.valueOf(!batch ? 1 : 0));
        linkedHashMap.put("fail_error_code", Long.valueOf(resultCode));
        linkedHashMap.put("op_type", Integer.valueOf(opType));
        fo.c.c("ev_qun_album_on_interact_op", linkedHashMap);
    }

    public void a2(boolean enable) {
        this.show = enable;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumCommentViewModel";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1(BusinessFeedData businessFeedData, Comment realComment, Comment fakeComment) {
        CellCommentInfo commentInfo;
        ArrayList<Comment> arrayList = (businessFeedData == null || (commentInfo = businessFeedData.getCommentInfo()) == null) ? null : commentInfo.commments;
        if (arrayList == null || arrayList.isEmpty() || realComment == null || fakeComment == null) {
            return;
        }
        ArrayList<Comment> arrayList2 = new ArrayList<>();
        for (Comment comment : arrayList) {
            if (comment.isFake && Intrinsics.areEqual(comment.clientKey, fakeComment.clientKey)) {
                realComment.isTempData = true;
                arrayList2.add(realComment);
            } else {
                arrayList2.add(comment);
            }
        }
        CellCommentInfo commentInfo2 = businessFeedData.getCommentInfo();
        if (commentInfo2 != null) {
            commentInfo2.commments = arrayList2;
        }
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.b(ef.b.a(businessFeedData), businessFeedData.getCommentInfo()), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2(BusinessFeedData businessFeedData, Comment comment) {
        if (comment == null) {
            return;
        }
        CellCommentInfo commentInfo = businessFeedData.getCommentInfo();
        ArrayList<Comment> arrayList = new ArrayList<>();
        ArrayList<Comment> arrayList2 = commentInfo.commments;
        if (arrayList2 != null) {
            for (Comment comment2 : arrayList2) {
                if (!Intrinsics.areEqual(comment.commentid, comment2.commentid)) {
                    arrayList.add(comment2);
                }
            }
        }
        commentInfo.commments = arrayList;
        commentInfo.commentNum--;
        commentInfo.serverRspTotalCommentNum--;
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.b(ef.b.a(businessFeedData), commentInfo), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c2(BusinessFeedData businessFeedData, Comment comment, Reply reply) {
        CellCommentInfo commentInfo;
        ArrayList<Comment> arrayList;
        Object obj;
        if (reply == null || comment == null || (arrayList = (commentInfo = businessFeedData.getCommentInfo()).commments) == null) {
            return;
        }
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((Comment) obj).commentid, comment.commentid)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Comment comment2 = (Comment) obj;
        if (comment2 == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        List<Reply> list = comment2.replies;
        if (list != null) {
            for (Reply reply2 : list) {
                if (!Intrinsics.areEqual(reply.replyId, reply2.replyId)) {
                    arrayList2.add(reply2);
                }
            }
        }
        comment2.replies = arrayList2;
        comment2.replyNum--;
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.b(ef.b.a(businessFeedData), commentInfo), true);
    }

    public final void S1(BusinessFeedData businessFeedData, Comment comment, Reply reply, boolean batch) {
        if (businessFeedData == null || comment == null || reply == null) {
            return;
        }
        this.mCommentRepo.f(batch, businessFeedData, comment, reply, new b());
    }

    public final void U1(BusinessFeedData businessFeedData, Comment comment, Reply reply, boolean batch) {
        if (businessFeedData == null || comment == null || reply == null) {
            return;
        }
        this.mCommentRepo.h(batch, businessFeedData, comment, reply, new d(businessFeedData, comment, reply));
    }
}
