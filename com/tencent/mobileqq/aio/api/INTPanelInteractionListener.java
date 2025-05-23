package com.tencent.mobileqq.aio.api;

import android.content.Context;
import android.widget.EditText;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J4\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/api/INTPanelInteractionListener;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Landroid/widget/EditText;", "editText", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/emosm/IAIOEmoticonUIHelper;", "emoticonUIHelper", "", "panelProvider", "Lcom/tencent/mobileqq/AIODepend/IPanelInteractionListener;", "getNTPanelInteractionListener", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface INTPanelInteractionListener extends QRouteApi {
    @NotNull
    IPanelInteractionListener getNTPanelInteractionListener(@NotNull Context context, @NotNull EditText editText, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull IAIOEmoticonUIHelper emoticonUIHelper, @Nullable Object panelProvider);
}
