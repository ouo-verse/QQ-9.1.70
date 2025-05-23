package com.tencent.qqnt.chats.view.api;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/chats/view/api/ISummaryApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isSupportSummaryNickEmojiAnimation", "", "()Z", "getSummartContentTextView", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "getSummaryNick", "", "nick", "chats_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface ISummaryApi extends QRouteApi {
    @NotNull
    TextView getSummartContentTextView(@NotNull Context context);

    @NotNull
    CharSequence getSummaryNick(@NotNull CharSequence nick);

    boolean isSupportSummaryNickEmojiAnimation();
}
