package com.tencent.guild.api.msglist;

import android.content.Context;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ark.ark;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Triple;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\bg\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H&J@\u0010\u0013\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00150\u00142\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001bH&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/guild/api/msglist/IGuildAIOLinkSpanApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", NodeProps.ON_CLICK, "", "url", "", "hashTagLinkParams", "", ark.APP_SPECIFIC_BIZSRC, AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "Landroid/view/View;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "onInlineBtnClick", "app", "Lmqq/app/AppRuntime;", "context", "Landroid/content/Context;", "data", "parseLinkSpan", "", "Lkotlin/Triple;", "", "content", "enableHashTagLink", "", "unMatchTypes", "", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGuildAIOLinkSpanApi extends QRouteApi {
    void onClick(@NotNull String url, @Nullable Object hashTagLinkParams, @NotNull String bizSrc, @NotNull View widget, @NotNull MsgRecord msgRecord);

    void onClick(@NotNull String url, @NotNull String bizSrc, @NotNull View widget, @NotNull MsgRecord msgRecord);

    void onInlineBtnClick(@NotNull AppRuntime app, @NotNull Context context, @NotNull String data);

    @NotNull
    List<Triple<String, Integer, Integer>> parseLinkSpan(@NotNull String content, boolean enableHashTagLink, @Nullable Set<Integer> unMatchTypes);
}
