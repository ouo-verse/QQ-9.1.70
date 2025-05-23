package com.tencent.mobileqq.guild.feed.detail.task;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.guild.feed.detail.CommentDataUtil;
import com.tencent.mobileqq.guild.feed.detail.event.GuildDoCommentEvent;
import com.tencent.mobileqq.guild.feed.publish.v;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.mobileqq.guild.feed.widget.comment.GuildFeedRichContentResultBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoReplyCallback;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0002\t\rB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/detail/task/k;", "", "Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedRichContentResultBean;", "richText", "Lcom/tencent/mobileqq/guild/feed/detail/task/k$b;", "callback", "", "c", "Lcom/tencent/mobileqq/guild/feed/detail/event/GuildFeedCommentEvent;", "a", "Lcom/tencent/mobileqq/guild/feed/detail/event/GuildFeedCommentEvent;", "mEvent", "Lcom/tencent/mobileqq/guild/feed/publish/v;", "b", "Lcom/tencent/mobileqq/guild/feed/publish/v;", "mMainTaskIoc", "<init>", "(Lcom/tencent/mobileqq/guild/feed/detail/event/GuildFeedCommentEvent;Lcom/tencent/mobileqq/guild/feed/publish/v;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildDoCommentEvent mEvent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final v mMainTaskIoc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J$\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/detail/task/k$b;", "", "", "retCode", "", "errMsg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyRsp;", "rsp", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", Const.BUNDLE_KEY_REQUEST, "", "b", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void a(long retCode, @Nullable String errMsg, @Nullable GProStDoReplyReq request);

        void b(long retCode, @Nullable String errMsg, @NotNull GProStDoReplyRsp rsp, @Nullable GProStDoReplyReq request);
    }

    public k(@NotNull GuildDoCommentEvent mEvent, @NotNull v mMainTaskIoc) {
        Intrinsics.checkNotNullParameter(mEvent, "mEvent");
        Intrinsics.checkNotNullParameter(mMainTaskIoc, "mMainTaskIoc");
        this.mEvent = mEvent;
        this.mMainTaskIoc = mMainTaskIoc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final k this$0, final GProStDoReplyReq request, final b callback, final int i3, final String str, boolean z16, final GProStDoReplyRsp gProStDoReplyRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.detail.task.j
            @Override // java.lang.Runnable
            public final void run() {
                k.e(i3, str, this$0, gProStDoReplyRsp, request, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(int i3, String str, k this$0, GProStDoReplyRsp gProStDoReplyRsp, GProStDoReplyReq request, b callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("GuildDoReplyTask", 1, " | isSuccess = " + z16 + " | retCode = " + i3 + " | errMsg = " + str + " | mainTaskId = " + this$0.mMainTaskIoc.getMMainTaskId());
        if (z16 && gProStDoReplyRsp != null) {
            callback.b(i3, str, gProStDoReplyRsp, request);
        } else {
            callback.a(i3, str, request);
        }
    }

    public final void c(@Nullable GuildFeedRichContentResultBean richText, @NotNull final b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("GuildDoReplyTask", 1, "[doReply]  | mainTaskId = " + this.mMainTaskIoc.getMMainTaskId());
        if (richText == null) {
            return;
        }
        final GProStDoReplyReq f16 = CommentDataUtil.f(this.mEvent, richText);
        o c16 = l.c();
        if (c16 != null) {
            c16.doReply(f16, new IGProDoReplyCallback() { // from class: com.tencent.mobileqq.guild.feed.detail.task.i
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoReplyCallback
                public final void onResult(int i3, String str, boolean z16, GProStDoReplyRsp gProStDoReplyRsp) {
                    k.d(k.this, f16, callback, i3, str, z16, gProStDoReplyRsp);
                }
            });
        }
    }
}
