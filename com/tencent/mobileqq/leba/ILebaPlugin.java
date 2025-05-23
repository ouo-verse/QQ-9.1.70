package com.tencent.mobileqq.leba;

import com.tencent.mobileqq.leba.entity.DefaultClickProcessor;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u001e\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\u0011H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/leba/ILebaPlugin;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "accountChange", "", "buildDefaultClickProcessor", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "getNewTabRedTypeInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;", "getTabRedTypeInfo", "Lcom/tencent/mobileqq/redtouch/RedTypeInfo;", "hiddeNewGuide", "perParseDns", "hostList", "", "", MQPSecJsPlugin.KEY_FROM, "redTouchContainerNewGuide", "", "qqleba-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes15.dex */
public interface ILebaPlugin extends QRouteApi {
    void accountChange();

    @NotNull
    DefaultClickProcessor buildDefaultClickProcessor();

    @Nullable
    BusinessInfoCheckUpdate.RedTypeInfo getNewTabRedTypeInfo();

    @Nullable
    RedTypeInfo getTabRedTypeInfo();

    void hiddeNewGuide();

    void perParseDns(@NotNull List<String> hostList, @NotNull String keyFrom);

    boolean redTouchContainerNewGuide();
}
