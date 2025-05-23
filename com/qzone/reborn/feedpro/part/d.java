package com.qzone.reborn.feedpro.part;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.reborn.feedpro.bean.QzoneFeedProClickedComment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonRichMsg;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedCommentManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.AddCommentRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DeleteCommentRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DeleteReplyRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtil;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001PB\u0007\u00a2\u0006\u0004\bM\u0010NJ\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J*\u0010\u001c\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0012\u0010\u001d\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010 \u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010!\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010#\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010$\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010&\u001a\u0004\u0018\u00010\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010'\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J6\u0010.\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020\u0007H\u0016J\b\u0010/\u001a\u00020\u0013H\u0004R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00105R\u0016\u0010A\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00105R\u0018\u0010D\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006Q"}, d2 = {"Lcom/qzone/reborn/feedpro/part/d;", "Lcom/qzone/reborn/feedpro/part/b;", "Lde/a;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "Lcom/qzone/reborn/feedpro/bean/QzoneFeedProClickedComment;", "clickedComment", "", "position", "", "E9", "M9", "Landroid/content/Intent;", "data", "H9", "Lwd/d;", "commentBean", "L9", "K9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "feedData", "feedPosition", "preAction", "showQuickComment", "y6", "T2", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "g7", "intent", ICustomDataEditor.STRING_ARRAY_PARAM_9, "G9", "cacheFeedKey", "J9", "T8", "v", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "comment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "reply", "dataPosInList", "P1", "I9", "Lcom/qzone/reborn/feedpro/viewmodel/c;", "d", "Lcom/qzone/reborn/feedpro/viewmodel/c;", "mFeedProViewModel", "e", "I", "mFeedPosition", "f", "Lcom/qzone/reborn/feedpro/bean/QzoneFeedProClickedComment;", "mClickComment", "Lcom/tencent/widget/ActionSheet;", tl.h.F, "Lcom/tencent/widget/ActionSheet;", "mCommentDeleteActionSheet", "i", "mPreAction", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mShowQuickComment", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "mFeedData", "Lcom/qzone/reborn/feedpro/utils/k;", "D", "Lcom/qzone/reborn/feedpro/utils/k;", "mCommentClickProcess", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedCommentManager;", "E", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedCommentManager;", "commentManager", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class d extends com.qzone.reborn.feedpro.part.b implements de.a {

    /* renamed from: C, reason: from kotlin metadata */
    private CommonFeed mFeedData;

    /* renamed from: D, reason: from kotlin metadata */
    private com.qzone.reborn.feedpro.utils.k mCommentClickProcess;

    /* renamed from: E, reason: from kotlin metadata */
    private QzoneFeedCommentManager commentManager = new QzoneFeedCommentManager();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.c mFeedProViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mFeedPosition;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QzoneFeedProClickedComment mClickComment;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ActionSheet mCommentDeleteActionSheet;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mPreAction;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mShowQuickComment;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/part/d$b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/DeleteReplyRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements DataCallback<DeleteReplyRsp> {
        b() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(DeleteReplyRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            com.qzone.reborn.util.o.f59556a.b("\u5220\u9664\u5931\u8d25");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/part/d$c", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/DeleteCommentRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements DataCallback<DeleteCommentRsp> {
        c() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(DeleteCommentRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            com.qzone.reborn.util.o.f59556a.b("\u5220\u9664\u5931\u8d25");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/part/d$d", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/AddCommentRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedpro.part.d$d, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public static final class C0453d implements DataCallback<AddCommentRsp> {
        C0453d() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(AddCommentRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            com.qzone.reborn.feedpro.utils.c.f54317a.a(errorCode, errorMsg, "\u8bc4\u8bba\u5931\u8d25");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(CommonFeed commonFeed, d this$0, QzoneFeedProClickedComment qzoneFeedProClickedComment, int i3, View view, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i16 == 0) {
            if (commonFeed != null) {
                this$0.E9(commonFeed, qzoneFeedProClickedComment, i3);
            }
            ActionSheet actionSheet = this$0.mCommentDeleteActionSheet;
            if (actionSheet != null) {
                actionSheet.dismiss();
            }
            ActionSheetHelper.dismissActionSheet(this$0.getActivity(), this$0.mCommentDeleteActionSheet);
        }
    }

    private final void K9(CommonFeed commonFeed, wd.d commentBean) {
        boolean z16 = false;
        if (commentBean.e() != null && (!r0.isEmpty())) {
            z16 = true;
        }
        if (z16) {
            x7.h.INSTANCE.a().q(commonFeed, commentBean);
            return;
        }
        List<CommonRichMsg> stringToRichMsg = CommonFeedDataUtil.INSTANCE.stringToRichMsg(commentBean.getCommentText());
        QzoneFeedCommentManager qzoneFeedCommentManager = this.commentManager;
        CommonCellCommon cellCommon = commonFeed.getCellCommon();
        qzoneFeedCommentManager.addTextComment(cellCommon != null ? cellCommon.getUnionId() : null, stringToRichMsg, commentBean.getIsPrivate(), new C0453d());
    }

    private final void L9(CommonFeed commonFeed, wd.d commentBean) {
        CommonComment comment;
        CommonUser user;
        QzoneFeedProClickedComment clickedComment = commentBean.getClickedComment();
        if (clickedComment == null || (comment = clickedComment.getComment()) == null) {
            return;
        }
        List<CommonRichMsg> stringToRichMsg = CommonFeedDataUtil.INSTANCE.stringToRichMsg(commentBean.getCommentText());
        QzoneFeedProClickedComment clickedComment2 = commentBean.getClickedComment();
        CommonReply reply = clickedComment2 != null ? clickedComment2.getReply() : null;
        if (reply != null) {
            user = reply.getUser();
        } else {
            user = comment.getUser();
        }
        CommonUser commonUser = user;
        if (commonUser != null) {
            QzoneFeedCommentManager qzoneFeedCommentManager = this.commentManager;
            CommonCellCommon cellCommon = commonFeed.getCellCommon();
            QzoneFeedCommentManager.addReply$default(qzoneFeedCommentManager, cellCommon != null ? cellCommon.getUnionId() : null, stringToRichMsg, comment, commonUser, null, 16, null);
        }
    }

    protected final String I9() {
        gf.k kVar = (gf.k) getIocInterface(gf.k.class);
        String h16 = kVar != null ? fo.c.h(kVar.getPageType()) : null;
        return h16 == null ? "" : h16;
    }

    public CommonFeed J9(String cacheFeedKey) {
        MutableLiveData<UIStateData<List<CommonFeed>>> N1;
        UIStateData<List<CommonFeed>> value;
        List<CommonFeed> data;
        if (this.mFeedProViewModel == null) {
            this.mFeedProViewModel = C9();
        }
        com.qzone.reborn.feedpro.viewmodel.c cVar = this.mFeedProViewModel;
        Object obj = null;
        if (cVar == null || (N1 = cVar.N1()) == null || (value = N1.getValue()) == null || (data = value.getData()) == null) {
            return null;
        }
        Iterator<T> it = data.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(CommonFeedExtKt.getFeedUniqueKey((CommonFeed) next), cacheFeedKey)) {
                obj = next;
                break;
            }
        }
        return (CommonFeed) obj;
    }

    @Override // de.a
    public void P1(View v3, CommonFeed feedData, CommonComment comment, CommonReply reply, int dataPosInList) {
        Intrinsics.checkNotNullParameter(v3, "v");
    }

    @Override // de.a
    public void T2(QzoneFeedProClickedComment clickedComment) {
        this.mClickComment = clickedComment;
    }

    @Override // de.a
    public void T8(CommonFeed feedData, QzoneFeedProClickedComment clickedComment, int position) {
        if (this.mCommentClickProcess == null) {
            com.qzone.reborn.feedpro.utils.k kVar = new com.qzone.reborn.feedpro.utils.k(getHostFragment());
            this.mCommentClickProcess = kVar;
            Intrinsics.checkNotNull(kVar);
            kVar.d(this);
            com.qzone.reborn.feedpro.utils.k kVar2 = this.mCommentClickProcess;
            Intrinsics.checkNotNull(kVar2);
            kVar2.e(I9());
        }
        com.qzone.reborn.feedpro.utils.k kVar3 = this.mCommentClickProcess;
        if (kVar3 != null) {
            kVar3.f(this.mShowQuickComment);
        }
        com.qzone.reborn.feedpro.utils.k kVar4 = this.mCommentClickProcess;
        if (kVar4 != null) {
            kVar4.c(feedData, clickedComment, position);
        }
    }

    @Override // de.a
    public void g7(final CommonFeed feedData, final QzoneFeedProClickedComment clickedComment, final int position) {
        if (com.qzone.reborn.feedx.util.l.b("QzoneFeedProCommentOperationPartdoDeleteCommentSheet", 500L)) {
            return;
        }
        ActionSheet.OnButtonClickListener onButtonClickListener = new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.feedpro.part.c
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                d.F9(CommonFeed.this, this, clickedComment, position, view, i3);
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ActionMenuItem(0, ActionSheetHelper.getStringById(getActivity(), R.string.gda), 0, 0, 2));
        com.qzone.widget.o a16 = com.qzone.widget.p.a(getActivity(), arrayList, onButtonClickListener);
        a16.addCancelButton(R.string.cancel);
        this.mCommentDeleteActionSheet = a16;
        ActionSheetHelper.showActionSheet(getActivity(), this.mCommentDeleteActionSheet);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFeedProCommentOperationPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            return;
        }
        if (requestCode == 1207) {
            a9(data);
        } else if (requestCode == 1208) {
            H9(data);
        }
        M9();
    }

    @Override // com.qzone.reborn.feedpro.part.b, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        registerIoc(this, de.a.class);
    }

    @Override // de.a
    public void y6(CommonFeed feedData, int feedPosition, int preAction, int showQuickComment) {
        this.mFeedData = feedData;
        this.mFeedPosition = feedPosition;
        this.mPreAction = preAction;
        this.mShowQuickComment = showQuickComment;
    }

    private final void H9(Intent data) {
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean;
        if (data != null && (qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) data.getParcelableExtra("comment_panel_result_bean")) != null) {
            if (TextUtils.isEmpty(qZoneCommentPanelResultBean.getInputContent())) {
                QLog.e("QzoneFeedProCommentOperationPart", 1, "doneReply  commentText == null");
                return;
            }
            wd.d dVar = new wd.d();
            dVar.j(qZoneCommentPanelResultBean.getInputContent());
            dVar.m(this.mFeedPosition);
            dVar.i(this.mClickComment);
            dVar.q("");
            dVar.h(qZoneCommentPanelResultBean.getCacheUniKey());
            dVar.n(qZoneCommentPanelResultBean.getIsCheckedPrivateIcon());
            dVar.g(qZoneCommentPanelResultBean.getCacheFeedsKey());
            dVar.o(false);
            dVar.k(dVar.d());
            G9(dVar);
            return;
        }
        QLog.e("QzoneFeedProCommentOperationPart", 1, "[getDoneReplyBeanNew] bean is not instanceof");
    }

    private final void M9() {
        this.mFeedPosition = 0;
        this.mClickComment = null;
    }

    public void a9(Intent intent) {
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean;
        if (intent != null && (qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) intent.getParcelableExtra("comment_panel_result_bean")) != null) {
            if (TextUtils.isEmpty(qZoneCommentPanelResultBean.getInputContent()) && bl.b(qZoneCommentPanelResultBean.g())) {
                QLog.e("QzoneFeedProCommentOperationPart", 1, "doneComment  commentText and pic is null");
                return;
            }
            wd.d dVar = new wd.d();
            dVar.j(qZoneCommentPanelResultBean.getInputContent());
            dVar.m(this.mFeedPosition);
            dVar.h(qZoneCommentPanelResultBean.getCacheUniKey());
            dVar.n(qZoneCommentPanelResultBean.getIsCheckedPrivateIcon());
            dVar.l(qZoneCommentPanelResultBean.g());
            dVar.g(qZoneCommentPanelResultBean.getCacheFeedsKey());
            dVar.o(qZoneCommentPanelResultBean.getIsEmoRapidComment());
            dVar.p(qZoneCommentPanelResultBean.getRapidCommentInfo());
            dVar.k(dVar.d());
            G9(dVar);
            return;
        }
        QLog.e("QzoneFeedProCommentOperationPart", 1, "[getDoneCommentBeanNew] data is null");
    }

    private final void E9(CommonFeed commonFeed, QzoneFeedProClickedComment clickedComment, int position) {
        CommonComment comment = clickedComment != null ? clickedComment.getComment() : null;
        CommonReply reply = clickedComment != null ? clickedComment.getReply() : null;
        if (comment == null) {
            QLog.d("QzoneFeedProCommentOperationPart", 1, "doDeleteCommentRequest fail, comment is null");
            return;
        }
        if (reply != null) {
            QzoneFeedCommentManager qzoneFeedCommentManager = this.commentManager;
            CommonCellCommon cellCommon = commonFeed.getCellCommon();
            qzoneFeedCommentManager.deleteReply(cellCommon != null ? cellCommon.getUnionId() : null, comment, reply, new b());
        } else {
            QzoneFeedCommentManager qzoneFeedCommentManager2 = this.commentManager;
            CommonCellCommon cellCommon2 = commonFeed.getCellCommon();
            qzoneFeedCommentManager2.deleteComment(cellCommon2 != null ? cellCommon2.getUnionId() : null, comment, new c());
        }
    }

    public void G9(wd.d commentBean) {
        CommonFeed J9;
        if (commentBean == null || (J9 = J9(commentBean.getCacheFeedKey())) == null) {
            return;
        }
        if (commentBean.getClickedComment() != null) {
            L9(J9, commentBean);
        } else {
            K9(J9, commentBean);
        }
    }
}
