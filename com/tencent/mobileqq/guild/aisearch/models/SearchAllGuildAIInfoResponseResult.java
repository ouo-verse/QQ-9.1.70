package com.tencent.mobileqq.guild.aisearch.models;

import com.tencent.mobileqq.guild.aisearch.models.a;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAllGuildAIInfoRsp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b+\u0010,J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000b\u0010\t\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010\n\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0013\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010&\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\u001e\u0010%R\u001d\u0010*\u001a\u00020\u000b8\u0006\u00a2\u0006\u0012\n\u0004\b'\u0010\u0010\u0012\u0004\b(\u0010)\u001a\u0004\b\u0018\u0010\u0012\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/h;", "", "", "queryText", "modelType", "", "Lcom/tencent/mobileqq/guild/aisearch/models/a;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAllGuildAIInfoRsp;", "a", "toString", "", "hashCode", "other", "", "equals", "I", "getResult", "()I", "result", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "errorMessage", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAllGuildAIInfoRsp;", "getResponse", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAllGuildAIInfoRsp;", "response", "Lri1/a;", "d", "Lri1/a;", "getError", "()Lri1/a;", "error", "e", "Z", "()Z", "isError", "f", "getErrorState$annotations", "()V", "errorState", "<init>", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAllGuildAIInfoRsp;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.aisearch.models.h, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class SearchAllGuildAIInfoResponseResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String errorMessage;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IGProGuildSearchAllGuildAIInfoRsp response;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ri1.a error;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isError;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int errorState;

    /* JADX WARN: Code restructure failed: missing block: B:38:0x007c, code lost:
    
        if (r0 != false) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SearchAllGuildAIInfoResponseResult(int i3, @Nullable String str, @Nullable IGProGuildSearchAllGuildAIInfoRsp iGProGuildSearchAllGuildAIInfoRsp) {
        boolean z16;
        String str2;
        boolean z17;
        IGProGuildSearchAISearchInfo aiSearchInfo;
        boolean z18;
        this.result = i3;
        this.errorMessage = str;
        this.response = iGProGuildSearchAllGuildAIInfoRsp;
        ri1.a c16 = ri1.a.c(i3, str == null ? "" : str, iGProGuildSearchAllGuildAIInfoRsp);
        Intrinsics.checkNotNullExpressionValue(c16, "error(result, errorMessage ?: \"\", response)");
        this.error = c16;
        boolean z19 = true;
        int i16 = 0;
        if (c16.d() && iGProGuildSearchAllGuildAIInfoRsp != null && iGProGuildSearchAllGuildAIInfoRsp.getAiSearchInfo() != null) {
            String searchKey = iGProGuildSearchAllGuildAIInfoRsp.getAiSearchInfo().getSearchKey();
            if (searchKey != null && searchKey.length() != 0) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (!z18) {
                z16 = false;
                this.isError = z16;
                if (c16.d()) {
                    i16 = 9;
                } else {
                    if (iGProGuildSearchAllGuildAIInfoRsp != null && (aiSearchInfo = iGProGuildSearchAllGuildAIInfoRsp.getAiSearchInfo()) != null) {
                        str2 = aiSearchInfo.getSearchKey();
                    } else {
                        str2 = null;
                    }
                    if (str2 != null && str2.length() != 0) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (!z17) {
                        String sessionId = iGProGuildSearchAllGuildAIInfoRsp != null ? iGProGuildSearchAllGuildAIInfoRsp.getSessionId() : null;
                        if (sessionId != null && sessionId.length() != 0) {
                            z19 = false;
                        }
                    }
                    i16 = 10;
                }
                this.errorState = i16;
            }
        }
        z16 = true;
        this.isError = z16;
        if (c16.d()) {
        }
        this.errorState = i16;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final IGProGuildSearchAllGuildAIInfoRsp getResponse() {
        return this.response;
    }

    @NotNull
    public final List<a> b(@NotNull String queryText, @NotNull String modelType) {
        List<a> listOf;
        Intrinsics.checkNotNullParameter(queryText, "queryText");
        Intrinsics.checkNotNullParameter(modelType, "modelType");
        if (this.response != null) {
            MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(new ChatAnswerData(0, null, null, 0L, 0L, 0L, 63, null));
            String userMsgId = this.response.getUserMsgId();
            Intrinsics.checkNotNullExpressionValue(userMsgId, "response.userMsgId");
            String answerMsgId = this.response.getAnswerMsgId();
            Intrinsics.checkNotNullExpressionValue(answerMsgId, "response.answerMsgId");
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new a[]{new a.QuestionItem(userMsgId, queryText, 0L, 4, null), new a.AnswerItem(answerMsgId, MutableStateFlow, this.response.getAiSearchInfo(), modelType, null, 0L, 48, null)});
            return listOf;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* renamed from: c, reason: from getter */
    public final int getErrorState() {
        return this.errorState;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsError() {
        return this.isError;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchAllGuildAIInfoResponseResult)) {
            return false;
        }
        SearchAllGuildAIInfoResponseResult searchAllGuildAIInfoResponseResult = (SearchAllGuildAIInfoResponseResult) other;
        if (this.result == searchAllGuildAIInfoResponseResult.result && Intrinsics.areEqual(this.errorMessage, searchAllGuildAIInfoResponseResult.errorMessage) && Intrinsics.areEqual(this.response, searchAllGuildAIInfoResponseResult.response)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.result * 31;
        String str = this.errorMessage;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        IGProGuildSearchAllGuildAIInfoRsp iGProGuildSearchAllGuildAIInfoRsp = this.response;
        if (iGProGuildSearchAllGuildAIInfoRsp != null) {
            i16 = iGProGuildSearchAllGuildAIInfoRsp.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "SearchAllGuildAIInfoResponseResult(result=" + this.result + ", errorMessage=" + this.errorMessage + ", response=" + this.response + ")";
    }
}
