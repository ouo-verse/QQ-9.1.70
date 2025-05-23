package com.tencent.mobileqq.search.searchdetail.content.model;

import android.graphics.Color;
import com.tencent.mobileqq.search.util.af;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchChannelConditonFilter;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupConditonFilter;
import com.tencent.qqnt.kernel.nativeinterface.SearchReqBody;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/model/h;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReqBody;", "", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;)Ljava/lang/Integer;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f283924a = new h();

    h() {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:3:0x0008, B:5:0x000d, B:11:0x001d, B:14:0x0053, B:16:0x0057, B:26:0x0081, B:29:0x0088, B:33:0x0077, B:25:0x0065), top: B:2:0x0008, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053 A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:3:0x0008, B:5:0x000d, B:11:0x001d, B:14:0x0053, B:16:0x0057, B:26:0x0081, B:29:0x0088, B:33:0x0077, B:25:0x0065), top: B:2:0x0008, inners: #1 }] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Integer a(@NotNull SearchText searchText) {
        String str;
        boolean z16;
        boolean z17;
        Object m476constructorimpl;
        boolean z18;
        boolean z19;
        Intrinsics.checkNotNullParameter(searchText, "<this>");
        try {
            str = searchText.colorToken;
            z16 = false;
        } catch (Exception e16) {
            af afVar = af.f284993a;
            QLog.e("QS.getTextColor", 1, "getTextColor error " + searchText.colorToken + " " + searchText.color, e16);
        }
        if (str != null) {
            if (str.length() > 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                z17 = true;
                if (!z17) {
                    return Integer.valueOf(BaseApplication.context.getResources().getColor(BaseApplication.context.getResources().getIdentifier("qui_common_" + searchText.colorToken, "color", BaseApplication.context.getPackageName())));
                }
                String str2 = searchText.color;
                if (str2 != null) {
                    if (str2.length() > 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        z16 = true;
                    }
                }
                if (z16) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        m476constructorimpl = Result.m476constructorimpl(Integer.valueOf(Color.parseColor(searchText.color)));
                    } catch (Throwable th5) {
                        Result.Companion companion2 = Result.INSTANCE;
                        m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                    }
                    if (Result.m482isFailureimpl(m476constructorimpl)) {
                        m476constructorimpl = null;
                    }
                    return (Integer) m476constructorimpl;
                }
                return null;
            }
        }
        z17 = false;
        if (!z17) {
        }
    }

    @NotNull
    public final String b(@NotNull SearchReqBody searchReqBody) {
        Intrinsics.checkNotNullParameter(searchReqBody, "<this>");
        StringBuilder sb5 = new StringBuilder("SearchReqBody");
        sb5.append(", keyWord=" + searchReqBody.keyWord);
        sb5.append(", tabs=" + searchReqBody.tabs);
        sb5.append(", firstPage=" + searchReqBody.firstPage);
        sb5.append(", disableCorrectionQuery=" + searchReqBody.disableCorrectionQuery);
        sb5.append(", lbs=" + af.b(searchReqBody.lbs, 0, 2, null));
        SearchChannelConditonFilter searchChannelConditonFilter = searchReqBody.channelConditionFilter;
        if (searchChannelConditonFilter.rankType != 0) {
            sb5.append(", channelConditionFilter=" + searchChannelConditonFilter);
        }
        SearchGroupConditonFilter searchGroupConditonFilter = searchReqBody.groupConditionFilter;
        if (searchGroupConditonFilter.groupRankType != 0) {
            sb5.append(", groupConditionFilter=" + searchGroupConditonFilter);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
        return sb6;
    }
}
