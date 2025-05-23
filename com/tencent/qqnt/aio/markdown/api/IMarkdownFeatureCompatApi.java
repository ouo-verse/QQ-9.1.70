package com.tencent.qqnt.aio.markdown.api;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00022\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\tH&J.\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/markdown/api/IMarkdownFeatureCompatApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "Landroid/content/Context;", "context", "", "url", "", "startUrl", "", "shouldUseSimpleBreakStrategy", "scene", "", Node.ATTRS_ATTR, "", "duration", "reportTimeCost", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes23.dex */
public interface IMarkdownFeatureCompatApi extends QRouteApi {
    /* synthetic */ void applyMarkdownStyle(@NotNull Context context, @NotNull Object obj, boolean z16);

    @Nullable
    /* synthetic */ Object getInlineButtonStyleSheet(@NotNull Context context, @NotNull Object obj, boolean z16);

    @NotNull
    /* synthetic */ CharSequence parse(@NotNull String str);

    @NotNull
    /* synthetic */ CharSequence parseExcludeExtData(@NotNull String str, int i3);

    void reportTimeCost(@NotNull String scene, @Nullable Map<String, String> attrs, double duration);

    boolean shouldUseSimpleBreakStrategy();

    void startUrl(@NotNull Context context, @NotNull String url);

    @Nullable
    /* synthetic */ String tryParse(@Nullable MsgAbstractElement msgAbstractElement);

    @Nullable
    /* synthetic */ String tryParse(@Nullable List<MsgAbstractElement> list);

    @Nullable
    /* synthetic */ String tryParseForChats(@NotNull Context context, @NotNull String str, @Nullable List<MsgAbstractElement> list);
}
