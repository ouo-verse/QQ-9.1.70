package com.tencent.mobileqq.guild.api;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IQQGuildJubaoApi extends QRouteApi {
    void actionSheetReport(QBaseActivity qBaseActivity, String str, String str2, String str3, String str4, int i3, String str5, int i16, String str6, String str7, boolean z16);

    void reportGuild(QBaseActivity qBaseActivity, String str, String str2, int i3, String str3, String str4);

    void reportGuild(QBaseActivity qBaseActivity, String str, String str2, int i3, boolean z16);

    void reportGuild(QBaseActivity qBaseActivity, String str, String str2, String str3, boolean z16, boolean z17);

    void reportGuildFeed(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @Nullable Function1<Integer, Unit> function1);

    void reportGuildFeedCommentAndReply(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, @Nullable String str6, @Nullable Function1<Integer, Unit> function1);
}
