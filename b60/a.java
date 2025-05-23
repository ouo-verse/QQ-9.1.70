package b60;

import com.tencent.biz.qqcircle.beans.QFSCommentPicInfo;
import com.tencent.biz.qqcircle.comment.emoji.QFSCommentEmojiOperationManager;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lb60/a;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lcom/tencent/biz/qqcircle/beans/QFSCommentPicInfo;", "info", "", "x9", "", "action", "", "args", "handleBroadcastMessage", "<init>", "()V", "d", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a extends u {
    private final void x9(QFSCommentPicInfo info) {
        String favEmojiUrl = info.getFavEmojiUrl();
        boolean z16 = true;
        QLog.d("QFSCommentFavEmojiPart", 1, "[handleFavEmoji] isEmojiPic=" + info.isEmojiPic() + ", url=" + favEmojiUrl);
        if (favEmojiUrl != null && favEmojiUrl.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        new QFSCommentEmojiOperationManager(favEmojiUrl, getContext()).e();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual("comment_pic_fav_emoji", action) && (args instanceof QFSCommentPicInfo)) {
            x9((QFSCommentPicInfo) args);
        }
    }
}
