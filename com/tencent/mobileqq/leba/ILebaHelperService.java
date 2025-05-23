package com.tencent.mobileqq.leba;

import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.tianshu.data.RedPointHolder;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes15.dex */
public interface ILebaHelperService extends IRuntimeService {
    void addLebaListener(ResourcePluginListener resourcePluginListener);

    void checkModleAndRefesh();

    void getAllPluginList(AppRuntime appRuntime);

    List<LebaPluginInfo> getLebaConfigList();

    Object getLebaHelper();

    List<n> getLebaMgrList();

    List<RedPointHolder> getLebaPluginRedPointIds();

    List<n> getLebaShowList();

    n getLebaViewItemById(long j3);

    void getUserSettingNet(AppRuntime appRuntime);

    void initLebaHelper();

    boolean isFeedGoOffline();

    boolean isNeedPreloadPlugin(String str);

    boolean isPluginInfoPatchEnable();

    boolean isPluginOpen(long j3);

    boolean isTableModel(AppRuntime appRuntime);

    boolean needShowRedDot(AppRuntime appRuntime, long j3, Set<Long> set);

    void netSetPluginState(String str, boolean z16, long j3);

    void notifyLebaStyleChange(boolean z16);

    void notifyPluginListChanged();

    void notifyRefreshWebProcess();

    void notifySetPluginState(int i3, boolean z16, Object obj);

    void notifyUpdatePluginPatch();

    void pluginInfoPatch(List<LebaPluginInfo> list);

    List<n> reloadLebaItems(AppRuntime appRuntime);

    void removeLebaListener(ResourcePluginListener resourcePluginListener);

    void reportPluginStatus(AppRuntime appRuntime);

    void setFlagBackFromMgr();

    void setFlagUpdateFinishResourceDownload();

    void setFlagUpdateFromH5();

    void setFlagUpdateOnPause();

    void updateAllLebaListFlag(List<BusinessInfoCheckUpdate.AppSetting> list);

    void updateAppSetting(AppRuntime appRuntime, long j3, boolean z16, long j16, long j17);

    void updateBuffer();
}
