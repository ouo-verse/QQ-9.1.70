package nl1;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildJubaoApi;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.util.LoadingUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import hl1.g;
import java.util.ArrayList;
import jl1.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yl1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J@\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004J*\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\"\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b0\u0012J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u001a"}, d2 = {"Lnl1/b;", "", "Landroid/content/Context;", "context", "", "guildId", "channelId", "feedId", "evilUin", "CommentId", WSAutoShowCommentParams.KEY_REPLY_ID, "", "c", "Lhl1/g;", "contentData", "b", "Landroid/view/View;", "view", "Lkotlin/Function1;", "", "callback", "e", "", "d", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f420422a = new b();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 callback, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (i3 != 0) {
            if (i3 == 1) {
                callback.invoke(1);
                actionSheet.dismiss();
                return;
            }
            return;
        }
        callback.invoke(0);
        actionSheet.dismiss();
    }

    public final void b(@NotNull g contentData, @NotNull Context context, @Nullable String channelId, @Nullable String guildId) {
        String str;
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Intrinsics.checkNotNullParameter(context, "context");
        if (contentData instanceof jl1.b) {
            FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
            ArrayList<GProStRichTextContent> arrayList = ((jl1.b) contentData).getCommentData().richContents.contents;
            Intrinsics.checkNotNullExpressionValue(arrayList, "contentData.commentData.richContents.contents");
            str = ((SpannableStringBuilder) FeedRichTextContentParser.s(feedRichTextContentParser, arrayList, null, null, channelId, guildId, 3, null).getFirst()).toString();
        } else if (contentData instanceof h) {
            FeedRichTextContentParser feedRichTextContentParser2 = FeedRichTextContentParser.f221393a;
            ArrayList<GProStRichTextContent> arrayList2 = ((h) contentData).getReplyData().richContents.contents;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "contentData.replyData.richContents.contents");
            str = ((SpannableStringBuilder) FeedRichTextContentParser.s(feedRichTextContentParser2, arrayList2, null, null, channelId, guildId, 3, null).getFirst()).toString();
        } else {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "when (contentData) {\n   \u2026\"\n            }\n        }");
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("simple text", str));
        n.B(true, R.string.f145210qv);
    }

    public final void c(@NotNull Context context, @NotNull String guildId, @NotNull String channelId, @NotNull String feedId, @NotNull String evilUin, @NotNull String CommentId, @Nullable String replyId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(evilUin, "evilUin");
        Intrinsics.checkNotNullParameter(CommentId, "CommentId");
        Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(context, "\u8bf7\u7a0d\u5019...", true);
        showLoadingDialog.show();
        ((IQQGuildJubaoApi) QRoute.api(IQQGuildJubaoApi.class)).reportGuildFeedCommentAndReply(context, guildId, channelId, feedId, evilUin, CommentId, replyId, null);
        showLoadingDialog.dismiss();
    }

    public final boolean d(@Nullable String guildId, @Nullable String channelId) {
        AppInterface appInterface;
        boolean z16 = true;
        if (!TextUtils.isEmpty(guildId) && !TextUtils.isEmpty(channelId)) {
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
            if (iGPSService == null) {
                return false;
            }
            if (!iGPSService.getGuildPermission(guildId).a(30002) && !iGPSService.getChannelPermission(guildId, channelId).a(30002)) {
                z16 = false;
            }
            return z16;
        }
        QLog.e("CommentItemOptionHelper", 1, "hasPostChannelContentPermission return, guildId=" + guildId + ", channelId=" + channelId);
        return false;
    }

    public final void e(@NotNull View view, @NotNull final Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Dialog createDialog = ActionSheetHelper.createDialog(view.getContext(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton("\u91cd\u65b0\u53d1\u9001");
        actionSheet.addButton(R.string.f170822ak3);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: nl1.a
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view2, int i3) {
                b.f(Function1.this, actionSheet, view2, i3);
            }
        });
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.show();
    }
}
