package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\t\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRight;", "", "()V", "blackUins", "", "", "getBlackUins", "()Ljava/util/List;", "setBlackUins", "(Ljava/util/List;)V", "flag", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/QzoneRightFlagEnum;", "getFlag", "setFlag", "questions", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRightQuestion;", "getQuestions", "setQuestions", "whiteGroups", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRightGroupItem;", "getWhiteGroups", "setWhiteGroups", "whiteUins", "getWhiteUins", "setWhiteUins", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonRight {
    public static final int $stable = 8;
    private List<Integer> flag = new ArrayList();
    private List<String> whiteUins = new ArrayList();
    private List<String> blackUins = new ArrayList();
    private List<CommonRightQuestion> questions = new ArrayList();
    private List<CommonRightGroupItem> whiteGroups = new ArrayList();

    public final List<String> getBlackUins() {
        return this.blackUins;
    }

    public final List<Integer> getFlag() {
        return this.flag;
    }

    public final List<CommonRightQuestion> getQuestions() {
        return this.questions;
    }

    public final List<CommonRightGroupItem> getWhiteGroups() {
        return this.whiteGroups;
    }

    public final List<String> getWhiteUins() {
        return this.whiteUins;
    }

    public final void setBlackUins(List<String> list) {
        this.blackUins = list;
    }

    public final void setFlag(List<Integer> list) {
        this.flag = list;
    }

    public final void setQuestions(List<CommonRightQuestion> list) {
        this.questions = list;
    }

    public final void setWhiteGroups(List<CommonRightGroupItem> list) {
        this.whiteGroups = list;
    }

    public final void setWhiteUins(List<String> list) {
        this.whiteUins = list;
    }
}
