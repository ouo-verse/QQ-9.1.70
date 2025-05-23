package com.tencent.robot.slash.dialog.search;

import j64.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/robot/slash/dialog/search/SearchException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "errorCode", "I", "getErrorCode", "()I", "setErrorCode", "(I)V", "", "errorMsg", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "Lj64/g;", "searchContext", "Lj64/g;", "getSearchContext", "()Lj64/g;", "<init>", "(ILjava/lang/String;Lj64/g;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SearchException extends Exception {
    private int errorCode;

    @NotNull
    private String errorMsg;

    @NotNull
    private final g searchContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchException(int i3, @NotNull String errorMsg, @NotNull g searchContext) {
        super(i3 + " " + errorMsg);
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Intrinsics.checkNotNullParameter(searchContext, "searchContext");
        this.errorCode = i3;
        this.errorMsg = errorMsg;
        this.searchContext = searchContext;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @NotNull
    public final g getSearchContext() {
        return this.searchContext;
    }

    public final void setErrorCode(int i3) {
        this.errorCode = i3;
    }

    public final void setErrorMsg(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errorMsg = str;
    }
}
