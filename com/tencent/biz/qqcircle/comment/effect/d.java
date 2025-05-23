package com.tencent.biz.qqcircle.comment.effect;

import qqcircle.QQCircleEnvHub$KeywordHighlightInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f83577a;

    /* renamed from: b, reason: collision with root package name */
    private String f83578b;

    /* renamed from: c, reason: collision with root package name */
    private QQCircleEnvHub$KeywordHighlightInfo f83579c;

    public d(boolean z16, String str, QQCircleEnvHub$KeywordHighlightInfo qQCircleEnvHub$KeywordHighlightInfo) {
        this.f83577a = z16;
        this.f83578b = str;
        this.f83579c = qQCircleEnvHub$KeywordHighlightInfo;
    }

    public String a() {
        return this.f83578b;
    }

    public QQCircleEnvHub$KeywordHighlightInfo b() {
        return this.f83579c;
    }

    public boolean c() {
        return this.f83577a;
    }

    public void d(boolean z16) {
        this.f83577a = z16;
    }

    public String toString() {
        return "QFSCommentEffectBean{mNeedShowKeywordHighlight=" + this.f83577a + ", mKeyword='" + this.f83578b + "', mKeywordHighlightInfo=" + this.f83579c + '}';
    }
}
