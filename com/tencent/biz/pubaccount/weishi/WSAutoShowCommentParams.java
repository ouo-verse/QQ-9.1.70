package com.tencent.biz.pubaccount.weishi;

import android.util.Log;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0013\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011B!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR$\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/WSAutoShowCommentParams;", "Ljava/io/Serializable;", "", "TAG", "Ljava/lang/String;", "", "<set-?>", WSAutoShowCommentParams.KEY_IS_SHOW_COMMENT_PANEL, "Z", "()Z", WSAutoShowCommentParams.KEY_COMMENT_ID, "getCommentId", "()Ljava/lang/String;", WSAutoShowCommentParams.KEY_REPLY_ID, "getReplyId", WadlProxyConsts.EXT_JSON, "<init>", "(Ljava/lang/String;)V", "(ZLjava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSAutoShowCommentParams implements Serializable {
    public static final String KEY_COMMENT = "comment";
    public static final String KEY_COMMENT_ID = "commentId";
    public static final String KEY_IS_SHOW_COMMENT_PANEL = "isShowCommentPanel";
    public static final String KEY_REPLY_ID = "replyId";
    private final String TAG;
    private String commentId;
    private boolean isShowCommentPanel;
    private String replyId;

    public WSAutoShowCommentParams(String str) {
        this.TAG = "WSAutoShowCommentParams";
        this.commentId = "";
        this.replyId = "";
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("comment");
            if (optJSONObject == null) {
                return;
            }
            this.isShowCommentPanel = optJSONObject.optInt(KEY_IS_SHOW_COMMENT_PANEL) == 1;
            String optString = optJSONObject.optString(KEY_COMMENT_ID);
            Intrinsics.checkNotNullExpressionValue(optString, "commentObject.optString(KEY_COMMENT_ID)");
            this.commentId = optString;
            String optString2 = optJSONObject.optString(KEY_REPLY_ID);
            Intrinsics.checkNotNullExpressionValue(optString2, "commentObject.optString(KEY_REPLY_ID)");
            this.replyId = optString2;
        } catch (JSONException e16) {
            com.tencent.biz.pubaccount.weishi.util.x.j(this.TAG, Log.getStackTraceString(e16));
        }
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    /* renamed from: isShowCommentPanel, reason: from getter */
    public final boolean getIsShowCommentPanel() {
        return this.isShowCommentPanel;
    }

    public WSAutoShowCommentParams(boolean z16, String commentId, String replyId) {
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        Intrinsics.checkNotNullParameter(replyId, "replyId");
        this.TAG = "WSAutoShowCommentParams";
        this.isShowCommentPanel = z16;
        this.commentId = commentId;
        this.replyId = replyId;
    }
}
