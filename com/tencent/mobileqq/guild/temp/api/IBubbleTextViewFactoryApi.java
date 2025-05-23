package com.tencent.mobileqq.guild.temp.api;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/IBubbleTextViewFactoryApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "createGuildETTextView", "createGuildEmoETTextView", "Ls02/a;", "createGuildLiveETTextView", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IBubbleTextViewFactoryApi extends QRouteApi {
    @NotNull
    TextView createGuildETTextView(@NotNull Context context);

    @NotNull
    TextView createGuildEmoETTextView(@NotNull Context context);

    @NotNull
    s02.a createGuildLiveETTextView(@NotNull Context context);
}
