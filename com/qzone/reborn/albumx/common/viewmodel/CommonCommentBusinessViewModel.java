package com.qzone.reborn.albumx.common.viewmodel;

import NS_MOBILE_OPERATION.MediaInfo;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.qzone.reborn.groupalbum.task.GroupAlbumPicCommentTask;
import com.qzone.util.ToastUtil;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010%\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001:\u0001nB\u0007\u00a2\u0006\u0004\bl\u0010mJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\"\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002J.\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0002J(\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J(\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J0\u0010 \u001a\u00020\u00062\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001bH\u0002J8\u0010$\u001a\u00020\u00062\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u001a\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u0016\u0010(\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\u0014\u0010*\u001a\u0004\u0018\u00010\u001b2\b\u0010)\u001a\u0004\u0018\u00010\u001bH\u0002J\u001a\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u0010.\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u00010,H\u0002J\u0012\u0010/\u001a\u0004\u0018\u00010,2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u00101\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u001dH\u0002J\u0010\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u00020\"H\u0002J\u0012\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&04J\u0016\u00107\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u001dJ\u0016\u00108\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u001dJ2\u0010<\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0016\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u001b09j\b\u0012\u0004\u0012\u00020\u001b`:H\u0016J\u001c\u0010=\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H$J \u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0004J(\u0010B\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0004J \u0010E\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\"H&J.\u0010F\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0016J6\u0010G\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H$J0\u0010H\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0004J(\u0010I\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0004J.\u0010J\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\"2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010K\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010M\u001a\u00020\"2\u0006\u0010L\u001a\u00020\u001bH\u0016J\u001a\u0010P\u001a\u00020\u00062\b\u0010N\u001a\u0004\u0018\u00010\u001b2\u0006\u0010O\u001a\u00020\"H\u0016J\"\u0010Q\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\u0006\u00106\u001a\u00020\u001dH$JZ\u0010T\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\"2\b\u0010S\u001a\u0004\u0018\u00010\u001b2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\"2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001bH\u0004J&\u0010V\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u001dR\u001a\u0010[\u001a\u00020\u001b8\u0004X\u0084D\u00a2\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u001a\u0010`\u001a\u00020\"8\u0004X\u0084D\u00a2\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R \u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR&\u0010g\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00190d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fR \u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\"0d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010fR \u0010k\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020,0d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010f\u00a8\u0006o"}, d2 = {"Lcom/qzone/reborn/albumx/common/viewmodel/CommonCommentBusinessViewModel;", "Lcom/qzone/reborn/base/n;", "Lcom/qzone/reborn/albumx/common/bean/d;", "feed", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "comment", "", "S1", "U1", "fakeComment", "realComment", "i2", "I2", "deleteComment", "rspComment", "o2", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "reply", "targetReply", "R1", "rsp", SemanticAttributes.DbSystemValues.H2, "H2", ICustomDataEditor.NUMBER_PARAM_2, "W1", "", "commentList", "", "id", "", "hasMore", "attachInfo", "j2", "groupId", "", "totalCommentNum", "k2", "v2", "Lcom/tencent/richframework/data/base/UIStateData;", "Lci/d;", "z2", "cellId", ICustomDataEditor.STRING_ARRAY_PARAM_2, "c2", "Lcom/qzone/reborn/albumx/common/viewmodel/CommonCommentBusinessViewModel$a;", "commentResponse", "x2", "d2", "state", "K2", "failMsgResId", "F2", "Landroidx/lifecycle/MutableLiveData;", "b2", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "w2", "B2", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "commentPics", "T1", "Z1", "operationType", "E2", "type", "p2", "r2", "action", "commentCount", "y2", "Q1", Constants.BASE_IN_PLUGIN_VERSION, "t2", "q2", "X1", "e2", "llocId", "f2", "feedId", WidgetCacheConstellationData.NUM, "J2", "C2", "retCode", "errMsg", "l2", "feedAttachInfo", Constants.MMCCID, "i", "Ljava/lang/String;", "getFAKE_ID", "()Ljava/lang/String;", "FAKE_ID", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "g2", "()I", "PAGE_LIMIT", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "mCommonListDataWrapper", "", "D", "Ljava/util/Map;", "mLoadedComments", "E", "mLoadedCommentsNum", UserInfo.SEX_FEMALE, "mLoadedCommentsResponse", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class CommonCommentBusinessViewModel extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String FAKE_ID = "fakeId_";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int PAGE_LIMIT = 20;

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<UIStateData<ci.d>> mCommonListDataWrapper = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private final Map<String, List<Comment>> mLoadedComments = new HashMap();

    /* renamed from: E, reason: from kotlin metadata */
    private final Map<String, Integer> mLoadedCommentsNum = new HashMap();

    /* renamed from: F, reason: from kotlin metadata */
    private final Map<String, a> mLoadedCommentsResponse = new HashMap();

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\f\u001a\u0004\b\u0005\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/reborn/albumx/common/viewmodel/CommonCommentBusinessViewModel$a;", "", "", "toString", "", "a", "Z", "b", "()Z", "e", "(Z)V", "hasMore", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "feedAttachInfo", "c", "f", "hasResponse", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean hasMore;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private String attachInfo;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean hasResponse;

        /* renamed from: a, reason: from getter */
        public final String getAttachInfo() {
            return this.attachInfo;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getHasMore() {
            return this.hasMore;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getHasResponse() {
            return this.hasResponse;
        }

        public final void d(String str) {
            this.attachInfo = str;
        }

        public final void e(boolean z16) {
            this.hasMore = z16;
        }

        public final void f(boolean z16) {
            this.hasResponse = z16;
        }

        public String toString() {
            return "CommentResponse{hasMore=" + this.hasMore + ", attachInfo='" + this.attachInfo + "', hasResponse='" + this.hasResponse + "'}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A2(CommonCommentBusinessViewModel this$0, UIStateData commentList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(commentList, "$commentList");
        this$0.mCommonListDataWrapper.postValue(commentList);
    }

    private final void F2(int failMsgResId) {
        if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ)) {
            ToastUtil.o(R.string.f1338579, 4);
        } else {
            ToastUtil.o(failMsgResId, 4);
        }
    }

    private final void H2(com.qzone.reborn.albumx.common.bean.d feed, Comment comment, Reply rsp) {
        List<Reply> list;
        User user;
        List<Comment> c26 = c2(feed.getLlocId());
        if (c26 != null && !c26.isEmpty()) {
            int size = c26.size();
            int i3 = 0;
            int i16 = 0;
            while (true) {
                if (i16 >= size) {
                    break;
                }
                Comment comment2 = c26.get(i16);
                if (comment2 == null || !TextUtils.equals(comment.commentid, comment2.commentid) || (list = comment2.replies) == null || list.isEmpty()) {
                    i16++;
                } else {
                    int size2 = list.size();
                    while (true) {
                        if (i3 >= size2) {
                            break;
                        }
                        Reply reply = list.get(i3);
                        if (reply != null && TextUtils.equals(reply.clientKey, rsp.clientKey)) {
                            if (TextUtils.isEmpty(rsp.user.nickName)) {
                                rsp.user.nickName = reply.user.nickName;
                            }
                            if (TextUtils.isEmpty(rsp.targetUser.nickName) && (user = reply.targetUser) != null) {
                                rsp.targetUser.nickName = user.nickName;
                            }
                            c26.get(i16).replies.set(i3, rsp);
                        } else {
                            i3++;
                        }
                    }
                }
            }
            this.mLoadedComments.put(feed.getLlocId(), c26);
            ci.d dVar = new ci.d();
            dVar.c(c26);
            dVar.d(feed.getLlocId());
            UIStateData<ci.d> dataList = UIStateData.obtainSuccess(true).setFinish(!x2(d2(feed.getLlocId()))).setDataList(dVar);
            Intrinsics.checkNotNullExpressionValue(dataList, "obtainSuccess<GroupAlbum\u2026aList(commentListWrapper)");
            z2(dataList);
            return;
        }
        QLog.e(getLogTag(), 1, "comment list is null");
    }

    private final void I2(com.qzone.reborn.albumx.common.bean.d feed, Comment fakeComment, Comment realComment) {
        List<Comment> c26 = c2(feed.getLlocId());
        if (c26 != null && !c26.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Comment comment : c26) {
                if (comment.isFake && Intrinsics.areEqual(comment.clientKey, realComment.clientKey)) {
                    arrayList.add(realComment);
                    QLog.e(getLogTag(), 1, "find fake id");
                } else {
                    arrayList.add(comment);
                }
            }
            this.mLoadedComments.put(feed.getLlocId(), arrayList);
            ci.d dVar = new ci.d();
            dVar.d(feed.getLlocId());
            dVar.c(arrayList);
            UIStateData<ci.d> dataList = UIStateData.obtainSuccess(true).setFinish(!x2(d2(feed.getLlocId()))).setDataList(dVar);
            Intrinsics.checkNotNullExpressionValue(dataList, "obtainSuccess<GroupAlbum\u2026aList(commentListWrapper)");
            z2(dataList);
            return;
        }
        QLog.e(getLogTag(), 1, "comment list is null");
    }

    private final void K2(String id5, boolean state) {
        if (this.mLoadedCommentsResponse.get(id5) == null) {
            return;
        }
        a aVar = this.mLoadedCommentsResponse.get(id5);
        Intrinsics.checkNotNull(aVar);
        aVar.f(state);
    }

    private final void R1(com.qzone.reborn.albumx.common.bean.d feed, Comment comment, Reply reply, Reply targetReply) {
        List<Comment> c26 = c2(feed.getLlocId());
        if (c26 != null && !c26.isEmpty()) {
            int size = c26.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                Comment comment2 = c26.get(i3);
                if (comment2 != null) {
                    if (TextUtils.equals(comment != null ? comment.commentid : null, comment2.commentid)) {
                        comment2.replies.add(reply);
                        break;
                    }
                }
                i3++;
            }
            this.mLoadedComments.put(feed.getLlocId(), c26);
            ci.d dVar = new ci.d();
            dVar.c(c26);
            dVar.d(feed.getLlocId());
            UIStateData<ci.d> dataList = UIStateData.obtainSuccess(true).setFinish(!x2(d2(feed.getLlocId()))).setDataList(dVar);
            Intrinsics.checkNotNullExpressionValue(dataList, "obtainSuccess<GroupAlbum\u2026aList(commentListWrapper)");
            z2(dataList);
            return;
        }
        QLog.e(getLogTag(), 1, "comment list is null");
    }

    private final void S1(com.qzone.reborn.albumx.common.bean.d feed, Comment comment) {
        List<Comment> c26 = c2(feed.getLlocId());
        if (c26 == null) {
            QLog.e(getLogTag(), 1, "comment list is null");
            return;
        }
        c26.add(comment);
        this.mLoadedComments.put(feed.getLlocId(), c26);
        ci.d dVar = new ci.d();
        dVar.d(feed.getLlocId());
        dVar.c(c26);
        UIStateData<ci.d> dataList = UIStateData.obtainSuccess(true).setFinish(!x2(d2(feed.getLlocId()))).setUpTurning(true).setDataList(dVar);
        Intrinsics.checkNotNullExpressionValue(dataList, "obtainSuccess<GroupAlbum\u2026aList(commentListWrapper)");
        z2(dataList);
    }

    private final void U1(com.qzone.reborn.albumx.common.bean.d feed, Comment comment) {
        List<Comment> c26 = c2(feed.getLlocId());
        if (c26 != null && !c26.isEmpty()) {
            int size = c26.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (TextUtils.equals(comment.commentid, c26.get(i3).commentid)) {
                    c26.remove(i3);
                    break;
                }
                i3++;
            }
            this.mLoadedComments.put(feed.getLlocId(), c26);
            ci.d dVar = new ci.d();
            dVar.d(feed.getLlocId());
            dVar.c(c26);
            UIStateData<ci.d> dataList = UIStateData.obtainSuccess(true).setFinish(!x2(d2(feed.getLlocId()))).setDataList(dVar);
            Intrinsics.checkNotNullExpressionValue(dataList, "obtainSuccess<GroupAlbum\u2026aList(commentListWrapper)");
            z2(dataList);
            return;
        }
        QLog.e(getLogTag(), 1, "comment list is null");
    }

    private final String a2(String cellId) {
        a aVar;
        if (!TextUtils.isEmpty(cellId) && (aVar = this.mLoadedCommentsResponse.get(cellId)) != null) {
            if (aVar.getHasResponse() && aVar.getHasMore() && aVar.getAttachInfo() != null) {
                return aVar.getAttachInfo();
            }
            QLog.i(getLogTag(), 1, "getAttachInfo " + aVar + ".toString()");
        }
        return null;
    }

    private final List<Comment> c2(String id5) {
        if (TextUtils.isEmpty(id5)) {
            return null;
        }
        return this.mLoadedComments.get(id5);
    }

    private final a d2(String id5) {
        if (TextUtils.isEmpty(id5)) {
            return null;
        }
        return this.mLoadedCommentsResponse.get(id5);
    }

    private final void h2(com.qzone.reborn.albumx.common.bean.d feed, Comment comment, Reply reply, Reply rsp) {
        QLog.e(getLogTag(), 1, "addCommentReply Success");
        J2(feed.getLlocId(), e2(feed) + 1);
        H2(feed, comment, rsp);
        y2(1, feed, 1);
    }

    private final void i2(com.qzone.reborn.albumx.common.bean.d feed, Comment fakeComment, Comment realComment) {
        realComment.user.nickName = fakeComment.user.nickName;
        J2(feed.getLlocId(), e2(feed) + 1);
        I2(feed, fakeComment, realComment);
        y2(1, feed, 1);
    }

    private final void j2(List<Comment> commentList, String id5, boolean hasMore, String attachInfo) {
        List<Comment> c26 = c2(id5);
        if (c26 != null) {
            QLog.d(getLogTag(), 1, "getCommentSize:" + (commentList != null ? Integer.valueOf(commentList.size()) : null) + ", attachInfo:" + attachInfo + "hasMore\uff1a" + hasMore);
            if (commentList != null) {
                c26.addAll(commentList);
            }
        }
        ci.d dVar = new ci.d();
        dVar.d(id5);
        dVar.c(c26);
        UIStateData<ci.d> loadMore = UIStateData.obtainSuccess(false).setFinish(!hasMore).setDataList(dVar).setLoadMore(true);
        Intrinsics.checkNotNullExpressionValue(loadMore, "obtainSuccess<GroupAlbum\u2026       .setLoadMore(true)");
        z2(loadMore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m2(CommonCommentBusinessViewModel this$0, boolean z16, String id5, String attachInfo, boolean z17, List list, String groupId, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id5, "$id");
        Intrinsics.checkNotNullParameter(attachInfo, "$attachInfo");
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        QLog.d(this$0.getLogTag(), 1, "handleCommentResponse Success  isLoadMore:" + z16);
        this$0.K2(id5, true);
        this$0.G2(id5, attachInfo, z17, z16);
        if (z16) {
            this$0.j2(list, id5, z17, attachInfo);
        } else {
            this$0.k2(list, groupId, id5, i3, z17);
        }
    }

    private final void n2(com.qzone.reborn.albumx.common.bean.d feed, Comment comment, Reply reply, Reply rsp) {
        QLog.e(getLogTag(), 1, "deleteCommentReply Success");
        J2(feed.getLlocId(), e2(feed) - 1);
        W1(feed, comment, reply);
        y2(2, feed, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s2(int i3, CommonCommentBusinessViewModel this$0, com.qzone.reborn.albumx.common.bean.d feed, Comment comment, Comment rspComment) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullParameter(comment, "$comment");
        Intrinsics.checkNotNullParameter(rspComment, "$rspComment");
        if (i3 != 0) {
            if (i3 == 1) {
                this$0.i2(feed, comment, rspComment);
                return;
            } else if (i3 != 2) {
                return;
            }
        }
        this$0.o2(feed, comment, rspComment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u2(int i3, CommonCommentBusinessViewModel this$0, com.qzone.reborn.albumx.common.bean.d feed, Comment comment, Reply reply, Reply rsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullParameter(comment, "$comment");
        Intrinsics.checkNotNullParameter(reply, "$reply");
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        if (i3 != 0) {
            if (i3 == 1) {
                this$0.h2(feed, comment, reply, rsp);
                return;
            } else if (i3 != 2) {
                return;
            }
        }
        this$0.n2(feed, comment, reply, rsp);
    }

    private final List<Comment> v2(String id5) {
        if (c2(id5) == null) {
            return new ArrayList();
        }
        return c2(id5);
    }

    private final void z2(final UIStateData<ci.d> commentList) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.albumx.common.viewmodel.g
            @Override // java.lang.Runnable
            public final void run() {
                CommonCommentBusinessViewModel.A2(CommonCommentBusinessViewModel.this, commentList);
            }
        });
    }

    public final void B2(String id5, boolean isLoadMore) {
        String str;
        Intrinsics.checkNotNullParameter(id5, "id");
        if (isLoadMore) {
            str = a2(id5);
            if (str == null) {
                QLog.e(getLogTag(), 1, "getComments loadMore , attachInfo is null ");
                return;
            }
            QLog.i(getLogTag(), 1, "getComments, attachInfo:" + str);
        } else {
            str = null;
        }
        this.mCommonListDataWrapper.postValue(UIStateData.obtainLoading());
        C2(id5, str, isLoadMore);
        K2(id5, false);
    }

    protected abstract void C2(String id5, String attachInfo, boolean isLoadMore);

    protected abstract void D2(int type, com.qzone.reborn.albumx.common.bean.d feed, Comment comment, Reply reply, Reply targetReply);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void E2(int operationType, com.qzone.reborn.albumx.common.bean.d feed, Comment comment);

    public final void G2(String id5, String feedAttachInfo, boolean hasMore, boolean isLoadMore) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(feedAttachInfo, "feedAttachInfo");
        if (this.mLoadedCommentsResponse.get(id5) != null) {
            if (isLoadMore) {
                a aVar = this.mLoadedCommentsResponse.get(id5);
                if (aVar != null) {
                    aVar.e(hasMore);
                }
                a aVar2 = this.mLoadedCommentsResponse.get(id5);
                if (aVar2 == null) {
                    return;
                }
                aVar2.d(feedAttachInfo);
                return;
            }
            return;
        }
        a aVar3 = new a();
        aVar3.d(feedAttachInfo);
        aVar3.e(hasMore);
        aVar3.f(true);
        this.mLoadedCommentsResponse.put(id5, aVar3);
        QLog.d(getLogTag(), 1, "getDetailCommentSize: feedAttachInfo:" + feedAttachInfo);
    }

    public void J2(String feedId, int num) {
        Integer valueOf = Integer.valueOf(num);
        Map<String, Integer> map = this.mLoadedCommentsNum;
        Intrinsics.checkNotNull(feedId);
        map.put(feedId, valueOf);
    }

    public void Q1(com.qzone.reborn.albumx.common.bean.d feed, Comment comment, Reply reply, Reply targetReply) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        if (comment != null && reply != null) {
            R1(feed, comment, reply, targetReply);
            D2(1, feed, comment, reply, targetReply);
        } else {
            QLog.e(getLogTag(), 1, "feed or comment or reply is null");
        }
    }

    public void T1(final com.qzone.reborn.albumx.common.bean.d feed, final Comment fakeComment, ArrayList<String> commentPics) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(commentPics, "commentPics");
        if (feed.getLlocId() != null && fakeComment != null) {
            S1(feed, fakeComment);
            if (commentPics.isEmpty()) {
                E2(1, feed, fakeComment);
                return;
            }
            String groupId = feed.getGroupId();
            String str = fakeComment.fakeUniKey;
            Intrinsics.checkNotNullExpressionValue(str, "fakeComment.fakeUniKey");
            new GroupAlbumPicCommentTask(0, groupId, commentPics, str, new Function1<MediaInfo, Unit>() { // from class: com.qzone.reborn.albumx.common.viewmodel.CommonCommentBusinessViewModel$addFeedCommentRequest$task$1
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
                    RFWLog.d(CommonCommentBusinessViewModel.this.getLogTag(), RFWLog.USR, "upload success, do comment, pic size: " + it.picinfolist.size());
                    fakeComment.commentPictureItems = ff.a.f398543a.f(it);
                    CommonCommentBusinessViewModel.this.E2(1, feed, fakeComment);
                }
            }).addToTaskQueen();
            return;
        }
        QLog.e(getLogTag(), 1, "feed or comment is null");
    }

    public final MutableLiveData<UIStateData<ci.d>> b2() {
        return this.mCommonListDataWrapper;
    }

    public int e2(com.qzone.reborn.albumx.common.bean.d feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        int f26 = f2(feed.getLlocId());
        return f26 == 0 ? feed.getCommentNum() : f26;
    }

    public int f2(String llocId) {
        Intrinsics.checkNotNullParameter(llocId, "llocId");
        Integer num = this.mLoadedCommentsNum.get(llocId);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g2, reason: from getter */
    public final int getPAGE_LIMIT() {
        return this.PAGE_LIMIT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p2(int type, com.qzone.reborn.albumx.common.bean.d feed, Comment comment) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(comment, "comment");
        if (type == 0) {
            ToastUtil.o(R.string.f133255m, 4);
        } else {
            if (type != 1) {
                return;
            }
            U1(feed, comment);
            ToastUtil.o(R.string.f133295q, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q2(int type, com.qzone.reborn.albumx.common.bean.d feed, Comment comment, Reply reply) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(reply, "reply");
        if (type == 1) {
            W1(feed, comment, reply);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r2(final int type, final com.qzone.reborn.albumx.common.bean.d feed, final Comment comment, final Comment rspComment) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(rspComment, "rspComment");
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.reborn.albumx.common.viewmodel.i
            @Override // java.lang.Runnable
            public final void run() {
                CommonCommentBusinessViewModel.s2(type, this, feed, comment, rspComment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t2(final int type, final com.qzone.reborn.albumx.common.bean.d feed, final Comment comment, final Reply reply, final Reply rsp) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.reborn.albumx.common.viewmodel.h
            @Override // java.lang.Runnable
            public final void run() {
                CommonCommentBusinessViewModel.u2(type, this, feed, comment, reply, rsp);
            }
        });
    }

    public final void w2(String id5, boolean isLoadMore) {
        Intrinsics.checkNotNullParameter(id5, "id");
        QLog.e(getLogTag(), 1, "initOrGetCommentsFromCache id=" + id5 + ", isLoadMore = " + isLoadMore);
        List<Comment> c26 = c2(id5);
        if (c26 == null) {
            QLog.e(getLogTag(), 1, "initOrGetCommentsFromCache comments not contains in map");
            B2(id5, isLoadMore);
            return;
        }
        ci.d dVar = new ci.d();
        dVar.d(id5);
        dVar.c(c26);
        UIStateData<ci.d> loadMore = UIStateData.obtainSuccess(true).setFinish(!x2(d2(id5))).setDataList(dVar).setLoadMore(false);
        Intrinsics.checkNotNullExpressionValue(loadMore, "obtainSuccess<GroupAlbum\u2026      .setLoadMore(false)");
        z2(loadMore);
    }

    public abstract void y2(int action, com.qzone.reborn.albumx.common.bean.d feed, int commentCount);

    private final boolean x2(a commentResponse) {
        if (commentResponse != null) {
            return commentResponse.getHasMore();
        }
        return false;
    }

    private final void k2(List<Comment> commentList, String groupId, String id5, int totalCommentNum, boolean hasMore) {
        if (commentList == null) {
            commentList = new ArrayList<>();
            QLog.e(getLogTag(), 1, "\u540e\u53f0\u8fd4\u56de\u8bc4\u8bba\u6570\u4e3a0");
        }
        this.mLoadedComments.put(id5, commentList);
        J2(id5, totalCommentNum);
        com.qzone.reborn.albumx.common.bean.d dVar = new com.qzone.reborn.albumx.common.bean.d();
        dVar.k(groupId);
        dVar.l(id5);
        y2(0, dVar, totalCommentNum);
        ci.d dVar2 = new ci.d();
        dVar2.d(id5);
        dVar2.c(commentList);
        if (commentList.isEmpty()) {
            UIStateData<ci.d> loadMore = UIStateData.obtainEmpty().setDataList(dVar2).setFinish(!hasMore).setLoadMore(false);
            Intrinsics.checkNotNullExpressionValue(loadMore, "obtainEmpty<GroupAlbumLa\u2026      .setLoadMore(false)");
            z2(loadMore);
        }
        UIStateData<ci.d> loadMore2 = UIStateData.obtainSuccess(false).setDataList(dVar2).setFinish(!hasMore).setLoadMore(false);
        Intrinsics.checkNotNullExpressionValue(loadMore2, "obtainSuccess<GroupAlbum\u2026      .setLoadMore(false)");
        z2(loadMore2);
    }

    private final void o2(com.qzone.reborn.albumx.common.bean.d feed, Comment deleteComment, Comment rspComment) {
        if (rspComment == null) {
            return;
        }
        QLog.d(getLogTag(), 1, "deleteFeedComment Success");
        J2(feed.getLlocId(), (e2(feed) - 1) - deleteComment.replyNum);
        U1(feed, deleteComment);
        y2(2, feed, 1);
    }

    private final void W1(com.qzone.reborn.albumx.common.bean.d feed, Comment comment, Reply reply) {
        if (comment == null || reply == null) {
            return;
        }
        String str = comment.commentid;
        String str2 = reply.replyId;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        List<Comment> c26 = c2(feed.getLlocId());
        if (c26 != null && !c26.isEmpty()) {
            int size = c26.size();
            int i3 = 0;
            int i16 = 0;
            while (true) {
                if (i16 >= size) {
                    break;
                }
                Comment comment2 = c26.get(i16);
                if (comment2 != null && TextUtils.equals(comment2.commentid, str)) {
                    List<Reply> list = comment2.replies;
                    int size2 = list.size();
                    while (true) {
                        if (i3 >= size2) {
                            break;
                        }
                        Reply reply2 = list.get(i3);
                        if (reply2 != null && TextUtils.equals(str2, reply2.replyId)) {
                            c26.get(i16).replies.remove(i3);
                            break;
                        }
                        i3++;
                    }
                } else {
                    i16++;
                }
            }
            this.mLoadedComments.put(feed.getLlocId(), c26);
            ci.d dVar = new ci.d();
            dVar.c(c26);
            dVar.d(feed.getLlocId());
            UIStateData<ci.d> dataList = UIStateData.obtainSuccess(true).setFinish(!x2(d2(feed.getLlocId()))).setDataList(dVar);
            Intrinsics.checkNotNullExpressionValue(dataList, "obtainSuccess<GroupAlbum\u2026aList(commentListWrapper)");
            z2(dataList);
            return;
        }
        QLog.e(getLogTag(), 1, "comment list is null");
    }

    public void Z1(com.qzone.reborn.albumx.common.bean.d feed, Comment comment) {
        boolean startsWith$default;
        if (feed != null && comment != null) {
            String str = comment.commentid;
            Intrinsics.checkNotNullExpressionValue(str, "comment.commentid");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, this.FAKE_ID, false, 2, null);
            if (startsWith$default) {
                QLog.d(getLogTag(), 1, "delete fake comment");
                U1(feed, comment);
                return;
            } else {
                E2(0, feed, comment);
                return;
            }
        }
        QLog.e(getLogTag(), 1, "feed or comment is null");
    }

    public void X1(int type, com.qzone.reborn.albumx.common.bean.d feed, Comment comment, Reply reply) {
        boolean startsWith$default;
        if (feed != null && comment != null && reply != null) {
            String str = reply.replyId;
            Intrinsics.checkNotNullExpressionValue(str, "reply.replyId");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, this.FAKE_ID, false, 2, null);
            if (startsWith$default) {
                QLog.d(getLogTag(), 1, "delete fake reply");
                W1(feed, comment, reply);
                return;
            } else {
                D2(type, feed, comment, reply, null);
                return;
            }
        }
        QLog.e(getLogTag(), 1, "feed or comment or reply is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l2(int retCode, String errMsg, final String groupId, final String id5, final int totalCommentNum, final List<Comment> commentList, final boolean hasMore, final boolean isLoadMore, final String attachInfo) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        QLog.e(getLogTag(), 1, "handleCommentListResponse  retCode=" + retCode + ", errMsg=" + errMsg + ", commentList.size=" + (commentList != null ? Integer.valueOf(commentList.size()) : null) + ", hasMore=" + hasMore + ", isLoadMore=" + isLoadMore + ", attachInfo=" + attachInfo);
        if (retCode != 0) {
            ci.d dVar = new ci.d();
            dVar.d(id5);
            dVar.c(v2(id5));
            UIStateData<ci.d> loadMore = UIStateData.obtainError(errMsg).setRetCode(retCode).setData(isLoadMore, dVar).setLoadMore(isLoadMore);
            Intrinsics.checkNotNullExpressionValue(loadMore, "obtainError<GroupAlbumLa\u2026 .setLoadMore(isLoadMore)");
            z2(loadMore);
            F2(R.string.f133606k);
            QLog.e(getLogTag(), 1, "getComment error:" + retCode + "  errorMsg:" + errMsg);
            return;
        }
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.reborn.albumx.common.viewmodel.j
            @Override // java.lang.Runnable
            public final void run() {
                CommonCommentBusinessViewModel.m2(CommonCommentBusinessViewModel.this, isLoadMore, id5, attachInfo, hasMore, commentList, groupId, totalCommentNum);
            }
        });
    }
}
