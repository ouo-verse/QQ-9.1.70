package com.tencent.mobileqq.main.api;

import android.widget.RelativeLayout;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH&J\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/main/api/IMainUIHelperApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/app/Frame;", AIInput.KEY_FRAME, "Landroid/widget/RelativeLayout;", "titleArea", "Lcom/tencent/mobileqq/resconfig/MainResourceConfig;", "resConfig", "", "updateHeight", "", "updateTitleBar", "Lcom/tencent/mobileqq/main/api/d;", "proxy", "", "Lcom/tencent/mobileqq/main/api/c;", "list", "Lcom/tencent/mobileqq/main/api/b;", "getFrameHost", "Lcom/tencent/mobileqq/main/api/a;", "param", "updateAccessibilitySeq", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes15.dex */
public interface IMainUIHelperApi extends QRouteApi {
    @NotNull
    b getFrameHost(@NotNull d proxy, @NotNull List<? extends c> list);

    void updateAccessibilitySeq(@NotNull a param);

    void updateTitleBar(@NotNull Frame frame, @NotNull RelativeLayout titleArea, @NotNull MainResourceConfig resConfig, boolean updateHeight);
}
