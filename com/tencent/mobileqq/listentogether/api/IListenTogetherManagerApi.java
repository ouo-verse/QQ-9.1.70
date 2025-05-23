package com.tencent.mobileqq.listentogether.api;

import com.tencent.mobileqq.listentogether.k;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000eH&J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0014\u001a\u00020\u000bH&J\u001a\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u0017H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/listentogether/api/IListenTogetherManagerApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "type", "", "uin", "", "isListenTogetherOpen", "isJoinSession", "Lorg/json/JSONObject;", "jsonObject", "", "startAioShareTogetherListen", "checkAndShowAioShareMusic", "Ljava/lang/Class;", "Lmqq/manager/Manager;", "getListenTogetherManager", "Lcom/tencent/mobileqq/listentogether/k;", "change", "setPlayChange", "pauseMusic", "Lcom/tencent/mobileqq/music/SongInfo;", "song", "", "shouldPlayMusic", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IListenTogetherManagerApi extends QRouteApi {
    void checkAndShowAioShareMusic(@Nullable JSONObject jsonObject);

    @NotNull
    Class<? extends Manager> getListenTogetherManager();

    boolean isJoinSession();

    boolean isListenTogetherOpen(int type, @Nullable String uin);

    void pauseMusic();

    void setPlayChange(@Nullable k change);

    void shouldPlayMusic(@Nullable SongInfo song, long uin);

    void startAioShareTogetherListen(@Nullable JSONObject jsonObject);
}
