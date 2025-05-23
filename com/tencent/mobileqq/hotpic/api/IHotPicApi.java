package com.tencent.mobileqq.hotpic.api;

import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicSendData;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import com.tencent.mobileqq.hotpic.f;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Metadata;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H&J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH&J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\nH&J\u001a\u0010\u001b\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\nH&J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0015H&J\b\u0010\u001e\u001a\u00020\u0012H&J\b\u0010\u001f\u001a\u00020\u0012H&J\b\u0010 \u001a\u00020\u0019H&J\b\u0010!\u001a\u00020\u0012H&J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\"H&J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H&J \u0010(\u001a\b\u0012\u0004\u0012\u00020\"0\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\nH&J\u001a\u0010)\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\nH&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/hotpic/api/IHotPicApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "url", "Ljava/net/URL;", "getHotPicURL", "Ljava/io/File;", "getDiskFile", "getDiskFilePath", "uin", "", "getHotPicRedDotStatus", "getURL", "Lmqq/manager/Manager;", "getHotPicManager", "manager", "Lcom/tencent/mobileqq/hotpic/f;", "listener", "", "initHotPicManager", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/hotpic/HotPicTagInfo;", "getHotPicTags", "getLastClickId", "tagId", "", "checkData", "requestHotPicList", "hotPicTagInfo", "processData", "clearHotPicListener", "cleanResource", "isNeedGuide", "markGuide", "Lcom/tencent/mobileqq/hotpic/HotPicData;", "sendPic", "addSendPic", "Ljava/util/LinkedList;", "Lcom/tencent/mobileqq/hotpic/HotPicSendData;", "getRecentSendPics", "getHotPics", "checkIsNoMoreIndex", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes9.dex */
public interface IHotPicApi extends QRouteApi {
    void addSendPic(@NotNull HotPicData sendPic);

    boolean checkData(@Nullable Manager manager, int tagId);

    boolean checkIsNoMoreIndex(@Nullable Manager manager, int tagId);

    void cleanResource();

    void clearHotPicListener();

    @Nullable
    File getDiskFile(@NotNull String url);

    @NotNull
    String getDiskFilePath(@NotNull String url);

    @Nullable
    Manager getHotPicManager();

    int getHotPicRedDotStatus(@NotNull String uin);

    @NotNull
    ArrayList<HotPicTagInfo> getHotPicTags(@Nullable Manager manager);

    @Nullable
    URL getHotPicURL(@NotNull String url);

    @NotNull
    ArrayList<HotPicData> getHotPics(@Nullable Manager manager, int tagId);

    int getLastClickId(@Nullable Manager manager);

    @NotNull
    LinkedList<HotPicSendData> getRecentSendPics();

    @Nullable
    URL getURL(@NotNull String url);

    void initHotPicManager(@Nullable Manager manager, @NotNull f listener);

    boolean isNeedGuide();

    void markGuide();

    void processData(@NotNull HotPicTagInfo hotPicTagInfo);

    void requestHotPicList(@Nullable Manager manager, int tagId);
}
