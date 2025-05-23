package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumAccessPermission;", "", "()V", "answer", "", "getAnswer", "()Ljava/lang/String;", "setAnswer", "(Ljava/lang/String;)V", "permissionType", "", "getPermissionType", "()I", "setPermissionType", "(I)V", "question", "getQuestion", "setQuestion", "whiteList", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;", "getWhiteList", "()Ljava/util/List;", "setWhiteList", "(Ljava/util/List;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonAlbumAccessPermission {
    public static final int $stable = 8;
    private int permissionType;
    private String question = "";
    private String answer = "";
    private List<CommonStUser> whiteList = new ArrayList();

    public final String getAnswer() {
        return this.answer;
    }

    public final int getPermissionType() {
        return this.permissionType;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final List<CommonStUser> getWhiteList() {
        return this.whiteList;
    }

    public final void setAnswer(String str) {
        this.answer = str;
    }

    public final void setPermissionType(int i3) {
        this.permissionType = i3;
    }

    public final void setQuestion(String str) {
        this.question = str;
    }

    public final void setWhiteList(List<CommonStUser> list) {
        this.whiteList = list;
    }
}
