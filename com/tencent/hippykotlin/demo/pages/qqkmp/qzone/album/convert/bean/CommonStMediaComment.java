package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMediaComment;", "", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "toJSONObject", "", "commentNum", "I", "getCommentNum", "()I", "setCommentNum", "(I)V", "<init>", "()V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStMediaComment {
    public static final int $stable = 8;
    private int commentNum;

    public final int getCommentNum() {
        return this.commentNum;
    }

    public final void setCommentNum(int i3) {
        this.commentNum = i3;
    }

    public final e toJSONObject() {
        e eVar = new e();
        eVar.t("commentNum", this.commentNum);
        return eVar;
    }
}
