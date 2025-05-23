package com.tencent.mobileqq.api;

import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.processor.b;
import com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u0010\u001a\u00020\u000eH&J\u0018\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013H&J\b\u0010\u0015\u001a\u00020\u000eH&J\b\u0010\u0016\u001a\u00020\u0002H&J\b\u0010\u0017\u001a\u00020\u0002H&J\b\u0010\u0018\u001a\u00020\u000eH&J\b\u0010\u0019\u001a\u00020\u000eH&J\b\u0010\u001a\u001a\u00020\u0002H&J\b\u0010\u001b\u001a\u00020\u000eH&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/api/IDrawerApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "isV9", "Lcom/tencent/mobileqq/app/QBaseActivity;", PM.BASE, "Lcom/tencent/mobileqq/qqsettingme/BaseQQSettingMeView;", "getQQSettingMeView", "", "getStaticFrameSavePath", "", "getQQSettingMeInitDelayTime", "", VipFunCallConstants.KEY_GROUP, "", "preloadDrawable", "preloadProcessors", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/processor/b;", "Lkotlin/collections/ArrayList;", "getProcessors", "clearAllCache", "currentIsV3", "needUsedV3", "preloadConfig", "clearConfig", "needReloadUI", "resetReloadUI", "drawer-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes11.dex */
public interface IDrawerApi extends QRouteApi {
    void clearAllCache();

    void clearConfig();

    boolean currentIsV3();

    @NotNull
    ArrayList<b> getProcessors();

    long getQQSettingMeInitDelayTime();

    @NotNull
    BaseQQSettingMeView getQQSettingMeView(boolean isV9, @NotNull QBaseActivity base);

    @NotNull
    String getStaticFrameSavePath();

    boolean needReloadUI();

    boolean needUsedV3();

    void preloadConfig();

    void preloadDrawable(int group);

    void preloadProcessors();

    void resetReloadUI();
}
