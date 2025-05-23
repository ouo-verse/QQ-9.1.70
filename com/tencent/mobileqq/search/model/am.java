package com.tencent.mobileqq.search.model;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/search/model/am;", "Lcom/tencent/mobileqq/search/model/v;", "", "f", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "setWord", "(Ljava/lang/String;)V", "word", tl.h.F, "k", "setHitKeyword", "hitKeyword", "i", "l", "setSugTransInfo", "sugTransInfo", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class am extends v {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String word;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String hitKeyword;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sugTransInfo;

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getHitKeyword() {
        return this.hitKeyword;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getSugTransInfo() {
        return this.sugTransInfo;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getWord() {
        return this.word;
    }
}
