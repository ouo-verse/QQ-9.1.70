package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send;

import android.app.Activity;
import android.util.ArrayMap;
import android.view.View;
import androidx.core.util.Predicate;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.InputFunctionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ReplyCommentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.CommentFeedRequestArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.FeedCommentTask;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.replycomment.ReplyCommentTask;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0004\u001b$)/\u0018\u0000 Z2\u00020\u0001:\u0001[B\u0007\u00a2\u0006\u0004\bX\u0010YJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ9\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u00028\u00000\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ+\u0010%\u001a\u00020$2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e2\u0006\u0010#\u001a\u00020\"H\u0002\u00a2\u0006\u0004\b%\u0010&J\u001f\u0010*\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010(\u001a\u00020'H\u0002\u00a2\u0006\u0004\b*\u0010+J+\u00100\u001a\u00020/2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0\u001e2\u0006\u0010#\u001a\u00020.H\u0002\u00a2\u0006\u0004\b0\u00101J\b\u00102\u001a\u00020\u0004H\u0002J\b\u00103\u001a\u00020\u0004H\u0002J\u0012\u00104\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u00105\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0002J\u0012\u00106\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u00107\u001a\u00020\u00042\u0006\u0010#\u001a\u00020.H\u0002J\u0012\u00108\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010:\u001a\u00020\u00042\u0006\u0010#\u001a\u000209H\u0002J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010#\u001a\u000209H\u0002J\u001c\u0010?\u001a\u0004\u0018\u00010\u00192\u0006\u0010=\u001a\u00020<2\b\u0010>\u001a\u0004\u0018\u00010\u000bH\u0002J\u001c\u0010B\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u00132\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010C\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u00132\u0006\u0010A\u001a\u00020\tH\u0002R&\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e0D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR \u0010L\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020I0H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR&\u0010N\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0\u001e0D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010FRD\u0010T\u001a2\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u000b\u0012\u0006\b\u0001\u0012\u00020\u000b0P0Oj\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u000b\u0012\u0006\b\u0001\u0012\u00020\u000b0P`Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010V\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/InputSendPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/c;", "provider", "ca", "T", "", "", "needRemove", "Landroidx/core/util/Predicate;", "predicate", "ga", "(Ljava/util/List;ZLandroidx/core/util/Predicate;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;", "feedDetailMainData", "com/tencent/mobileqq/guild/feed/nativedetail/bottom/send/InputSendPart$getCommentRequestCallback$1", "L9", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;)Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/InputSendPart$getCommentRequestCallback$1;", "Lkotlin/Pair;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", QQPermissionConstants.Permission.AUIDO_GROUP, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$d;", "msg", "com/tencent/mobileqq/guild/feed/nativedetail/bottom/send/InputSendPart$getCommentResendCallback$1", "M9", "(Lkotlin/Pair;Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$d;)Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/InputSendPart$getCommentResendCallback$1;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;", "replyCommentArgs", "com/tencent/mobileqq/guild/feed/nativedetail/bottom/send/InputSendPart$getReplyCommentRequestCallback$1", "O9", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;)Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/InputSendPart$getReplyCommentRequestCallback$1;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$o;", "com/tencent/mobileqq/guild/feed/nativedetail/bottom/send/InputSendPart$getReplyCommentReSendCallback$1", "N9", "(Lkotlin/Pair;Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$o;)Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/InputSendPart$getReplyCommentReSendCallback$1;", "initData", "aa", "R9", "X9", "V9", "Y9", "Z9", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$r;", "T9", "P9", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/InputFunctionType;", "type", "extData", "K9", "isSuccess", "errMsg", "da", "ea", "Ljava/util/LinkedList;", "d", "Ljava/util/LinkedList;", "pendingCommentRequests", "Landroid/util/ArrayMap;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/ICommentTask;", "e", "Landroid/util/ArrayMap;", "pendingSendTaskList", "f", "pendingReplyRequests", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/framework/RequestSenderCallback;", "Lkotlin/collections/ArrayList;", tl.h.F, "Ljava/util/ArrayList;", "callbackList", "i", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/c;", "commentReplyArgsProvider", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class InputSendPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<Pair<GProStDoCommentReq, GProStComment>> pendingCommentRequests = new LinkedList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayMap<String, ICommentTask> pendingSendTaskList = new ArrayMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<Pair<GProStDoReplyReq, GProStReply>> pendingReplyRequests = new LinkedList<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RequestSenderCallback<? extends Object, ? extends Object>> callbackList = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c commentReplyArgsProvider;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f220742a;

        static {
            int[] iArr = new int[InputFunctionType.values().length];
            try {
                iArr[InputFunctionType.FUNCTION_TYPE_COMMENT_FEED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InputFunctionType.FUNCTION_TYPE_REPLY_COMMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f220742a = iArr;
        }
    }

    private final a.CommentMainFeedData K9(InputFunctionType type, Object extData) {
        a.OnCommentMainFeedDataResult onCommentMainFeedDataResult;
        Object broadcastGetMessage = broadcastGetMessage("message_get_comment_feed_data", extData);
        if (broadcastGetMessage instanceof a.OnCommentMainFeedDataResult) {
            onCommentMainFeedDataResult = (a.OnCommentMainFeedDataResult) broadcastGetMessage;
        } else {
            onCommentMainFeedDataResult = null;
        }
        if (onCommentMainFeedDataResult == null) {
            return null;
        }
        return onCommentMainFeedDataResult.getMainFeedData();
    }

    private final InputSendPart$getCommentRequestCallback$1 L9(a.CommentMainFeedData feedDetailMainData) {
        return new InputSendPart$getCommentRequestCallback$1(this, feedDetailMainData);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.InputSendPart$getCommentResendCallback$1] */
    private final InputSendPart$getCommentResendCallback$1 M9(final Pair<GProStDoCommentReq, GProStComment> record, final a.CommentRequestOperation msg2) {
        return new RequestSenderCallback<GProStDoCommentReq, GProStDoCommentRsp>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.InputSendPart$getCommentResendCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(true);
            }

            private final void h(String errMsg) {
                LifecycleCoroutineScope e16 = com.tencent.mobileqq.guild.feed.part.a.e(InputSendPart.this);
                if (e16 != null) {
                    BuildersKt__Builders_commonKt.launch$default(e16, null, null, new InputSendPart$getCommentResendCallback$1$notifyFailAndToast$1(InputSendPart.this, errMsg, msg2, record, null), 3, null);
                }
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public void e(@NotNull ICommentTask task, @NotNull GProStDoCommentReq req) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(req, "req");
                h("");
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public void f(int result, @NotNull String errMsg, @NotNull GProStDoCommentReq req, @Nullable GProStDoCommentRsp rsp) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(req, "req");
                if (yl1.n.v(result)) {
                    errMsg = "";
                }
                h(errMsg);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void g(@NotNull GProStDoCommentReq req, @NotNull GProStDoCommentRsp rsp) {
                LinkedList linkedList;
                LinkedList linkedList2;
                ArrayMap arrayMap;
                ArrayMap arrayMap2;
                Intrinsics.checkNotNullParameter(req, "req");
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                InputSendPart.this.da(true, "");
                linkedList = InputSendPart.this.pendingCommentRequests;
                InputSendPart inputSendPart = InputSendPart.this;
                Pair<GProStDoCommentReq, GProStComment> pair = record;
                synchronized (linkedList) {
                    linkedList2 = inputSendPart.pendingCommentRequests;
                    linkedList2.remove(pair);
                }
                arrayMap = InputSendPart.this.pendingSendTaskList;
                InputSendPart inputSendPart2 = InputSendPart.this;
                a.CommentRequestOperation commentRequestOperation = msg2;
                synchronized (arrayMap) {
                    arrayMap2 = inputSendPart2.pendingSendTaskList;
                }
                InputSendPart.this.broadcastMessage("message_comment_request_operation_result", new a.CommentRequestOperationResult(true, msg2, record.getSecond(), record.getFirst(), rsp));
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.InputSendPart$getReplyCommentReSendCallback$1] */
    private final InputSendPart$getReplyCommentReSendCallback$1 N9(final Pair<GProStDoReplyReq, GProStReply> record, final a.ReplyRequestOperation msg2) {
        return new RequestSenderCallback<GProStDoReplyReq, GProStDoReplyRsp>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.InputSendPart$getReplyCommentReSendCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(true);
            }

            private final void h(String errMsg) {
                LifecycleCoroutineScope e16 = com.tencent.mobileqq.guild.feed.part.a.e(InputSendPart.this);
                if (e16 != null) {
                    BuildersKt__Builders_commonKt.launch$default(e16, null, null, new InputSendPart$getReplyCommentReSendCallback$1$notifyFailAndToast$1(InputSendPart.this, errMsg, msg2, record, null), 3, null);
                }
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public void e(@NotNull ICommentTask task, @NotNull GProStDoReplyReq req) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(req, "req");
                h("");
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public void f(int result, @NotNull String errMsg, @NotNull GProStDoReplyReq req, @Nullable GProStDoReplyRsp rsp) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(req, "req");
                if (yl1.n.v(result)) {
                    errMsg = "";
                }
                h(errMsg);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void g(@NotNull GProStDoReplyReq req, @NotNull GProStDoReplyRsp rsp) {
                LinkedList linkedList;
                LinkedList linkedList2;
                ArrayMap arrayMap;
                ArrayMap arrayMap2;
                Intrinsics.checkNotNullParameter(req, "req");
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                InputSendPart.this.ea(true, "");
                linkedList = InputSendPart.this.pendingReplyRequests;
                InputSendPart inputSendPart = InputSendPart.this;
                Pair<GProStDoReplyReq, GProStReply> pair = record;
                synchronized (linkedList) {
                    linkedList2 = inputSendPart.pendingReplyRequests;
                    linkedList2.remove(pair);
                }
                arrayMap = InputSendPart.this.pendingSendTaskList;
                InputSendPart inputSendPart2 = InputSendPart.this;
                a.ReplyRequestOperation replyRequestOperation = msg2;
                synchronized (arrayMap) {
                    arrayMap2 = inputSendPart2.pendingSendTaskList;
                }
                InputSendPart.this.broadcastMessage("message_reply_request_operation_result", new a.ReplyRequestOperationResult(true, msg2, record.getSecond(), record.getFirst(), rsp));
            }
        };
    }

    private final InputSendPart$getReplyCommentRequestCallback$1 O9(a.CommentMainFeedData feedDetailMainData, ReplyCommentArgs replyCommentArgs) {
        return new InputSendPart$getReplyCommentRequestCallback$1(feedDetailMainData, replyCommentArgs, this);
    }

    private final void P9(a.TryToSendInputContentMessage msg2) {
        boolean isBlank;
        boolean z16;
        boolean z17;
        a.CommentMainFeedData K9 = K9(msg2.getInputArgs().getInputFunctionType(), msg2.getExtData());
        com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
        final IPerformanceReportTask n3 = cVar.n(K9, msg2, false);
        if (K9 == null) {
            QLog.e("InputSendPart", 1, "handleCommentFeed feedDetailMainData is null");
            yl1.n.z(0, R.string.f143860n8);
            cVar.b(n3, "stage_finish", -1L, "args error");
            return;
        }
        final CommentFeedRequestArgs commentFeedRequestArgs = new CommentFeedRequestArgs(K9.getFeedId(), K9.getGuildId(), K9.getChannelId(), K9.getCreateTime(), K9.getPosterId(), false, 32, null);
        c cVar2 = this.commentReplyArgsProvider;
        if (cVar2 != null) {
            cVar2.b(commentFeedRequestArgs);
        }
        String content = msg2.getContent();
        if (content == null) {
            content = "";
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(content);
        if (isBlank) {
            ArrayList<LocalMediaInfo> d16 = msg2.d();
            if (d16 != null && !d16.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                yl1.n.z(0, R.string.f143820n4);
                cVar.b(n3, "stage_finish", -1L, "empty msg");
                return;
            }
        }
        ArrayList<LocalMediaInfo> d17 = msg2.d();
        if (d17 == null) {
            d17 = new ArrayList<>();
        }
        final ArrayList<LocalMediaInfo> arrayList = d17;
        Boolean originalPic = msg2.getOriginalPic();
        if (originalPic != null) {
            z16 = originalPic.booleanValue();
        } else {
            z16 = false;
        }
        final InputSendPart$getCommentRequestCallback$1 L9 = L9(K9);
        this.callbackList.add(L9);
        final String str = content;
        final boolean z18 = z16;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.h
            @Override // java.lang.Runnable
            public final void run() {
                InputSendPart.Q9(InputSendPart.this, n3, L9, commentFeedRequestArgs, str, arrayList, z18);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(final InputSendPart this$0, final IPerformanceReportTask reportTask, final InputSendPart$getCommentRequestCallback$1 callback, final CommentFeedRequestArgs commentFeedRequestArgs, final String finalContent, final ArrayList localMediaInfo, final boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportTask, "$reportTask");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(commentFeedRequestArgs, "$commentFeedRequestArgs");
        Intrinsics.checkNotNullParameter(finalContent, "$finalContent");
        Intrinsics.checkNotNullParameter(localMediaInfo, "$localMediaInfo");
        if (this$0.getHostFragment().getView() == null) {
            QLog.e("InputSendPart", 1, "handleCommentFeed hostFragment destroy");
            com.tencent.mobileqq.guild.feed.report.c.f223280a.b(reportTask, "stage_finish", -1L, "host fragment destroyed");
        } else {
            FeedCommentTask.INSTANCE.a(new Function1<FeedCommentTask, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.InputSendPart$handleCommentFeed$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FeedCommentTask feedCommentTask) {
                    invoke2(feedCommentTask);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull FeedCommentTask build) {
                    Intrinsics.checkNotNullParameter(build, "$this$build");
                    build.J(new WeakReference<>(InputSendPart$getCommentRequestCallback$1.this));
                    build.o(com.tencent.mobileqq.guild.feed.part.a.d(this$0));
                    build.L(commentFeedRequestArgs);
                    build.n(finalContent);
                    build.p(localMediaInfo);
                    build.q(z16);
                    build.K(reportTask);
                }
            }).m();
        }
    }

    private final void R9(final Object msg2) {
        GProStComment gProStComment;
        GProStDoCommentReq gProStDoCommentReq;
        if (!(msg2 instanceof a.CommentRequestOperation)) {
            QLog.e("InputSendPart", 1, "handleCommentRequestOperation args error!");
            return;
        }
        a.CommentRequestOperation commentRequestOperation = (a.CommentRequestOperation) msg2;
        if (commentRequestOperation.getOperation() == 1) {
            Pair pair = (Pair) ha(this, this.pendingCommentRequests, false, new Predicate() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.f
                @Override // androidx.core.util.Predicate
                public final boolean test(Object obj) {
                    boolean S9;
                    S9 = InputSendPart.S9(msg2, (Pair) obj);
                    return S9;
                }
            }, 1, null);
            if (pair != null) {
                gProStComment = (GProStComment) pair.getSecond();
            } else {
                gProStComment = null;
            }
            if (pair != null) {
                gProStDoCommentReq = (GProStDoCommentReq) pair.getFirst();
            } else {
                gProStDoCommentReq = null;
            }
            broadcastMessage("message_comment_request_operation_result", new a.CommentRequestOperationResult(true, commentRequestOperation, gProStComment, gProStDoCommentReq, null));
            return;
        }
        if (commentRequestOperation.getOperation() == 2) {
            X9(commentRequestOperation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean S9(Object obj, Pair pair) {
        return Intrinsics.areEqual(((GProStComment) pair.getSecond()).idd, ((a.CommentRequestOperation) obj).getCommentId());
    }

    private final void T9(final a.TryToSendInputContentMessage msg2) {
        boolean isBlank;
        final boolean z16;
        boolean z17;
        if (msg2.getInputArgs().getReplyCommentArgs() == null) {
            QLog.i("InputSendPart", 1, "handleReplyComment replyCommentArgs is null");
            return;
        }
        final a.CommentMainFeedData K9 = K9(msg2.getInputArgs().getInputFunctionType(), msg2.getExtData());
        com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
        final IPerformanceReportTask n3 = cVar.n(K9, msg2, true);
        if (K9 == null) {
            QLog.e("InputSendPart", 1, "handleReplyComment feedDetailMainData is null");
            yl1.n.z(0, R.string.f145140qo);
            cVar.b(n3, "stage_finish", -1L, "args error");
            return;
        }
        String content = msg2.getContent();
        if (content == null) {
            content = "";
        }
        final String str = content;
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (isBlank) {
            ArrayList<LocalMediaInfo> d16 = msg2.d();
            if (d16 != null && !d16.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                yl1.n.z(0, R.string.f143820n4);
                cVar.b(n3, "stage_finish", -1L, "empty msg");
                return;
            }
        }
        ArrayList<LocalMediaInfo> d17 = msg2.d();
        if (d17 == null) {
            d17 = new ArrayList<>();
        }
        final ArrayList<LocalMediaInfo> arrayList = d17;
        Boolean originalPic = msg2.getOriginalPic();
        if (originalPic != null) {
            z16 = originalPic.booleanValue();
        } else {
            z16 = false;
        }
        final InputSendPart$getReplyCommentRequestCallback$1 O9 = O9(K9, msg2.getInputArgs().getReplyCommentArgs());
        this.callbackList.add(O9);
        c cVar2 = this.commentReplyArgsProvider;
        if (cVar2 != null) {
            cVar2.a(msg2.getInputArgs().getReplyCommentArgs());
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.g
            @Override // java.lang.Runnable
            public final void run() {
                InputSendPart.U9(InputSendPart.this, n3, str, arrayList, z16, O9, msg2, K9);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(final InputSendPart this$0, final IPerformanceReportTask reportTask, final String finalContent, final ArrayList localMediaInfo, final boolean z16, final InputSendPart$getReplyCommentRequestCallback$1 callback, final a.TryToSendInputContentMessage msg2, final a.CommentMainFeedData commentMainFeedData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportTask, "$reportTask");
        Intrinsics.checkNotNullParameter(finalContent, "$finalContent");
        Intrinsics.checkNotNullParameter(localMediaInfo, "$localMediaInfo");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        if (this$0.getHostFragment().getView() == null) {
            QLog.e("InputSendPart", 1, "handleReplyComment hostFragment destroy");
            com.tencent.mobileqq.guild.feed.report.c.f223280a.b(reportTask, "stage_finish", -1L, "host fragment destroyed");
        } else {
            ReplyCommentTask.INSTANCE.a(new Function1<ReplyCommentTask, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.InputSendPart$handleReplyComment$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ReplyCommentTask replyCommentTask) {
                    invoke2(replyCommentTask);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ReplyCommentTask build) {
                    Intrinsics.checkNotNullParameter(build, "$this$build");
                    build.n(finalContent);
                    build.p(localMediaInfo);
                    build.q(z16);
                    build.J(new WeakReference<>(callback));
                    build.M(msg2.getInputArgs().getReplyCommentArgs());
                    build.K(commentMainFeedData);
                    build.o(com.tencent.mobileqq.guild.feed.part.a.d(this$0));
                    build.L(reportTask);
                }
            }).m();
        }
    }

    private final void V9(final Object args) {
        GProStReply gProStReply;
        GProStDoReplyReq gProStDoReplyReq;
        if (!(args instanceof a.ReplyRequestOperation)) {
            QLog.e("InputSendPart", 1, "handleReplyRequestOperation args error!");
            return;
        }
        a.ReplyRequestOperation replyRequestOperation = (a.ReplyRequestOperation) args;
        if (replyRequestOperation.getOperation() == 1) {
            Pair pair = (Pair) ha(this, this.pendingReplyRequests, false, new Predicate() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.d
                @Override // androidx.core.util.Predicate
                public final boolean test(Object obj) {
                    boolean W9;
                    W9 = InputSendPart.W9(args, (Pair) obj);
                    return W9;
                }
            }, 1, null);
            if (pair != null) {
                gProStReply = (GProStReply) pair.getSecond();
            } else {
                gProStReply = null;
            }
            if (pair != null) {
                gProStDoReplyReq = (GProStDoReplyReq) pair.getFirst();
            } else {
                gProStDoReplyReq = null;
            }
            broadcastMessage("message_reply_request_operation_result", new a.ReplyRequestOperationResult(true, replyRequestOperation, gProStReply, gProStDoReplyReq, null));
            return;
        }
        if (replyRequestOperation.getOperation() == 2) {
            Y9(replyRequestOperation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean W9(Object obj, Pair pair) {
        return Intrinsics.areEqual(((GProStReply) pair.getSecond()).idd, ((a.ReplyRequestOperation) obj).getReplyId());
    }

    private final void X9(a.CommentRequestOperation msg2) {
        FeedCommentTask feedCommentTask;
        Object obj;
        Pair<GProStDoCommentReq, GProStComment> pair;
        synchronized (this.pendingCommentRequests) {
            Iterator<T> it = this.pendingCommentRequests.iterator();
            while (true) {
                feedCommentTask = null;
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((GProStComment) ((Pair) obj).getSecond()).idd, msg2.getCommentId())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            pair = (Pair) obj;
        }
        if (pair != null && this.pendingSendTaskList.containsKey(msg2.getCommentId())) {
            if (yl1.n.d(false, 0, 3, null)) {
                broadcastMessage("message_comment_request_operation_result", new a.CommentRequestOperationResult(false, msg2, pair.getSecond(), pair.getFirst(), null));
                return;
            }
            synchronized (this.pendingSendTaskList) {
                ICommentTask iCommentTask = this.pendingSendTaskList.get(msg2.getCommentId());
                InputSendPart$getCommentResendCallback$1 M9 = M9(pair, msg2);
                this.callbackList.add(M9);
                if (iCommentTask instanceof FeedCommentTask) {
                    feedCommentTask = (FeedCommentTask) iCommentTask;
                }
                if (feedCommentTask != null) {
                    feedCommentTask.J(new WeakReference<>(M9));
                }
                if (iCommentTask != null) {
                    iCommentTask.l();
                    Unit unit = Unit.INSTANCE;
                }
            }
            return;
        }
        QLog.e("InputSendPart", 1, "resend comment error, record of comment:" + msg2.getCommentId() + " not exist!");
        broadcastMessage("message_comment_request_operation_result", new a.CommentRequestOperationResult(false, msg2, null, null, null));
    }

    private final void Y9(a.ReplyRequestOperation msg2) {
        ReplyCommentTask replyCommentTask;
        Object obj;
        Pair<GProStDoReplyReq, GProStReply> pair;
        synchronized (this.pendingReplyRequests) {
            Iterator<T> it = this.pendingReplyRequests.iterator();
            while (true) {
                replyCommentTask = null;
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((GProStReply) ((Pair) obj).getSecond()).idd, msg2.getReplyId())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            pair = (Pair) obj;
        }
        if (pair != null && this.pendingSendTaskList.containsKey(msg2.getReplyId())) {
            if (yl1.n.d(false, 0, 3, null)) {
                broadcastMessage("message_reply_request_operation_result", new a.ReplyRequestOperationResult(false, msg2, pair.getSecond(), pair.getFirst(), null));
                return;
            }
            synchronized (this.pendingSendTaskList) {
                ICommentTask iCommentTask = this.pendingSendTaskList.get(msg2.getReplyId());
                InputSendPart$getReplyCommentReSendCallback$1 N9 = N9(pair, msg2);
                this.callbackList.add(N9);
                if (iCommentTask instanceof ReplyCommentTask) {
                    replyCommentTask = (ReplyCommentTask) iCommentTask;
                }
                if (replyCommentTask != null) {
                    replyCommentTask.J(new WeakReference<>(N9));
                }
                if (iCommentTask != null) {
                    iCommentTask.l();
                    Unit unit = Unit.INSTANCE;
                }
            }
            return;
        }
        QLog.e("InputSendPart", 1, "resend reply error, record of replyId:" + msg2.getReplyId() + " not exist!");
        broadcastMessage("message_reply_request_operation_result", new a.ReplyRequestOperationResult(false, msg2, null, null, null));
    }

    private final void Z9(Object args) {
        if (!(args instanceof a.TryToSendInputContentMessage)) {
            QLog.e("InputSendPart", 1, "handleTryToSendInputContentMessage args error!");
            return;
        }
        a.TryToSendInputContentMessage tryToSendInputContentMessage = (a.TryToSendInputContentMessage) args;
        QLog.i("InputSendPart", 1, "handleTryToSendInputContentMessage " + tryToSendInputContentMessage.getInputArgs().getInputFunctionType());
        int i3 = b.f220742a[tryToSendInputContentMessage.getInputArgs().getInputFunctionType().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                T9(tryToSendInputContentMessage);
            }
        } else {
            P9(tryToSendInputContentMessage);
        }
        if (tryToSendInputContentMessage.getNeedClearInput()) {
            broadcastMessage("message_clear_input", null);
        }
    }

    private final void aa() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.e
            @Override // java.lang.Runnable
            public final void run() {
                InputSendPart.ba();
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.getGuildUserNick("0", iGPSService.getSelfTinyId());
            iGPSService.getGuildUserAvatarUrl("0", iGPSService.getSelfTinyId(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void da(boolean isSuccess, String errMsg) {
        int i3;
        boolean z16;
        if (!isSuccess) {
            if (errMsg != null && errMsg.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                yl1.n.A(1, errMsg);
                return;
            }
        }
        if (isSuccess) {
            i3 = R.string.f143870n9;
        } else {
            i3 = R.string.f143860n8;
        }
        yl1.n.B(isSuccess, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ea(boolean isSuccess, String errMsg) {
        int i3;
        boolean z16;
        if (!isSuccess) {
            if (errMsg.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                yl1.n.A(1, errMsg);
                return;
            }
        }
        if (isSuccess) {
            i3 = R.string.f145150qp;
        } else {
            i3 = R.string.f145140qo;
        }
        yl1.n.B(isSuccess, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
    
        r0.remove();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r5 == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> T ga(List<T> list, boolean z16, Predicate<T> predicate) {
        T t16;
        synchronized (list) {
            Iterator<T> it = list.iterator();
            t16 = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                t16 = it.next();
                if (predicate.test(t16)) {
                    break;
                }
            }
        }
        return t16;
    }

    static /* synthetic */ Object ha(InputSendPart inputSendPart, List list, boolean z16, Predicate predicate, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return inputSendPart.ga(list, z16, predicate);
    }

    private final void initData() {
        aa();
    }

    public final void ca(@NotNull c provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.commentReplyArgsProvider = provider;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -1651505249) {
                if (hashCode != 1151112981) {
                    if (hashCode == 1751847274 && action.equals("message_reply_request_operation")) {
                        V9(args);
                        return;
                    }
                    return;
                }
                if (action.equals("message_try_to_send_input_content")) {
                    Z9(args);
                    return;
                }
                return;
            }
            if (action.equals("message_comment_request_operation")) {
                R9(args);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        initData();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        QLog.i("InputSendPart", 2, "onPartDestroy");
        this.callbackList.clear();
    }
}
