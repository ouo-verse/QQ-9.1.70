package com.tencent.mobileqq.guild.temp.api;

import android.content.Context;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ark.ark;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Triple;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J:\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&J \u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002H&J@\u0010\u001c\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u001b0\u001a2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H&\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/IGuildAIOLinkSpanUtilsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "url", ark.APP_SPECIFIC_BIZSRC, "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "", "hashTagLinkParams", "uin", "Lcom/tencent/mobileqq/data/MessageRecord;", "msg", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "data", "onInlineBtnClick", "content", "", "enableHashTagLink", "", "", "unMatchTypes", "", "Lkotlin/Triple;", "parseLinkSpan", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildAIOLinkSpanUtilsApi extends QRouteApi {
    void onClick(@NotNull String url, @Nullable Object hashTagLinkParams, @NotNull String bizSrc, @NotNull View widget, @NotNull String uin, @NotNull MessageRecord msg2);

    void onClick(@NotNull String url, @NotNull String bizSrc, @NotNull View widget);

    void onInlineBtnClick(@NotNull AppRuntime app, @NotNull Context context, @NotNull String data);

    @NotNull
    List<Triple<String, Integer, Integer>> parseLinkSpan(@NotNull String content, boolean enableHashTagLink, @Nullable Set<Integer> unMatchTypes);
}
