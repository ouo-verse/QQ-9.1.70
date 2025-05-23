package com.tencent.mobileqq.qwallet.hb;

import android.widget.ImageView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qwallet.hb.send.PanelEntryData;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.qwallet.hb.view.FestivalHbPagView;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tk2.FestivalHbData;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\tH&J\u001a\u0010\f\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J5\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00122#\u0010\u0019\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00110\u0014H&J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0015H&J!\u0010!\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00122\u0006\u0010 \u001a\u00020\u001fH&\u00a2\u0006\u0004\b!\u0010\"J \u0010&\u001a\u00020\u00112\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u001c0#j\b\u0012\u0004\u0012\u00020\u001c`$H&J\n\u0010(\u001a\u0004\u0018\u00010'H&J \u0010,\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)H&J\b\u0010-\u001a\u00020\u0011H&J\b\u0010.\u001a\u00020\u0011H&J\b\u0010/\u001a\u00020\u0004H&J\u0018\u00103\u001a\u00020\u00112\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u000200H&J\b\u00104\u001a\u00020\u0012H&\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/IQWalletFestivalHbApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ltk2/a$b;", "anim", "", "isAllAnimResReady", "isBgResExists", "isFgEnterResExists", "isFgLoopResExists", "", WadlProxyConsts.RES_URL, "suffix", "getResPath", "Lcom/tencent/mobileqq/qwallet/preload/DownloadParam;", "params", "Lcom/tencent/mobileqq/qwallet/preload/IPreloadService$c;", "listener", "", "", "skinId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "Lkotlin/ParameterName;", "name", "hbSkinData", "receiver", "getSkinData", "skinData", "Ltk2/a;", "convertHbData", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "Lcom/tencent/mobileqq/qwallet/hb/send/PanelEntryData;", "panelData", "verifyPanelData", "(Ljava/lang/Integer;Lcom/tencent/mobileqq/qwallet/hb/send/PanelEntryData;)Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "preDownloadSkinRes", "Lorg/json/JSONObject;", "getFestivalHbPanelConfig", "Lcom/tencent/mobileqq/qwallet/hb/view/FestivalHbPagView;", "animBgView", "animFgView", "playPagAnim", "releasePagAnim", "checkIfNeedLoadLightSdk", "checkIfDisablePag", "Landroid/widget/ImageView;", "ivOutClose", "ivInClose", "adjustClosePosition", "getCurrentScreenWidth", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletFestivalHbApi extends QRouteApi {
    void adjustClosePosition(@NotNull ImageView ivOutClose, @NotNull ImageView ivInClose);

    boolean checkIfDisablePag();

    void checkIfNeedLoadLightSdk();

    @NotNull
    FestivalHbData convertHbData(@NotNull HbSkinData skinData);

    int getCurrentScreenWidth();

    @Nullable
    JSONObject getFestivalHbPanelConfig();

    @Nullable
    String getResPath(@Nullable String resUrl, @NotNull String suffix);

    void getResPath(@NotNull DownloadParam params, @Nullable IPreloadService.c listener);

    void getSkinData(int skinId, @NotNull Function1<? super HbSkinData, Unit> receiver);

    boolean isAllAnimResReady(@NotNull FestivalHbData.Anim anim);

    boolean isBgResExists(@NotNull FestivalHbData.Anim anim);

    boolean isFgEnterResExists(@NotNull FestivalHbData.Anim anim);

    boolean isFgLoopResExists(@NotNull FestivalHbData.Anim anim);

    void playPagAnim(@NotNull FestivalHbData.Anim anim, @NotNull FestivalHbPagView animBgView, @NotNull FestivalHbPagView animFgView);

    void preDownloadSkinRes(@NotNull ArrayList<FestivalHbData> list);

    void releasePagAnim();

    boolean verifyPanelData(@Nullable Integer sessionType, @NotNull PanelEntryData panelData);
}
