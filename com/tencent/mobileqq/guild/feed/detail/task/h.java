package com.tencent.mobileqq.guild.feed.detail.task;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.guild.feed.detail.CommentDataUtil;
import com.tencent.mobileqq.guild.feed.detail.event.GuildDoCommentEvent;
import com.tencent.mobileqq.guild.feed.publish.v;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.mobileqq.guild.feed.widget.comment.GuildFeedRichContentResultBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoCommentCallback;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0002\n\u000eB\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/detail/task/h;", "", "Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedRichContentResultBean;", "richText", "Lcom/tencent/mobileqq/guild/feed/detail/task/h$b;", "callback", "", "c", "f", "Lcom/tencent/mobileqq/guild/feed/detail/event/GuildFeedCommentEvent;", "a", "Lcom/tencent/mobileqq/guild/feed/detail/event/GuildFeedCommentEvent;", "mEvent", "Lcom/tencent/mobileqq/guild/feed/publish/v;", "b", "Lcom/tencent/mobileqq/guild/feed/publish/v;", "mMainTaskIoc", "<init>", "(Lcom/tencent/mobileqq/guild/feed/detail/event/GuildFeedCommentEvent;Lcom/tencent/mobileqq/guild/feed/publish/v;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildDoCommentEvent mEvent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final v mMainTaskIoc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J$\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/detail/task/h$b;", "", "", "retCode", "", "errMsg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentRsp;", "rsp", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", Const.BUNDLE_KEY_REQUEST, "", "b", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void a(long retCode, @Nullable String errMsg, @Nullable GProStDoCommentReq request);

        void b(long retCode, @Nullable String errMsg, @NotNull GProStDoCommentRsp rsp, @NotNull GProStDoCommentReq request);
    }

    public h(@NotNull GuildDoCommentEvent mEvent, @NotNull v mMainTaskIoc) {
        Intrinsics.checkNotNullParameter(mEvent, "mEvent");
        Intrinsics.checkNotNullParameter(mMainTaskIoc, "mMainTaskIoc");
        this.mEvent = mEvent;
        this.mMainTaskIoc = mMainTaskIoc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final h this$0, final b callback, final GProStDoCommentReq request, final int i3, final String str, boolean z16, final GProStDoCommentRsp gProStDoCommentRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(request, "$request");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.detail.task.g
            @Override // java.lang.Runnable
            public final void run() {
                h.e(i3, str, this$0, gProStDoCommentRsp, callback, request);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(int i3, String str, h this$0, GProStDoCommentRsp gProStDoCommentRsp, b callback, GProStDoCommentReq request) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(request, "$request");
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("GuildDoCommentTask", 1, " | isSuccess = " + z16 + " | retCode = " + i3 + " | errMsg = " + str + " | mainTaskId = " + this$0.mMainTaskIoc.getMMainTaskId());
        if (z16 && gProStDoCommentRsp != null) {
            callback.b(i3, str, gProStDoCommentRsp, request);
        } else {
            callback.a(i3, str, request);
        }
    }

    public final void c(@Nullable GuildFeedRichContentResultBean richText, @NotNull final b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("GuildDoCommentTask", 1, "doComment | mainTaskId = " + this.mMainTaskIoc.getMMainTaskId());
        if (richText == null) {
            return;
        }
        final GProStDoCommentReq e16 = CommentDataUtil.e(this.mEvent, richText);
        o c16 = l.c();
        if (c16 != null) {
            c16.doComment(e16, new IGProDoCommentCallback() { // from class: com.tencent.mobileqq.guild.feed.detail.task.f
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoCommentCallback
                public final void onResult(int i3, String str, boolean z16, GProStDoCommentRsp gProStDoCommentRsp) {
                    h.d(h.this, callback, e16, i3, str, z16, gProStDoCommentRsp);
                }
            });
        }
    }

    public final void f() {
    }
}
