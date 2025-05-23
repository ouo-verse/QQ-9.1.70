package com.tencent.mobileqq.gdtad.api.videocelling;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\tH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/gdtad/api/videocelling/IGdtVideoCellingAPI;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "startActivity", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "cls", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGdtVideoCellingAPI extends QRouteApi {
    void startActivity(@NotNull Context context, @Nullable Intent intent, @Nullable Class<? extends QBaseFragment> cls);
}
