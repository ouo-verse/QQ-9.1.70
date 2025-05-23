package com.tencent.mobileqq.zootopia.service.api;

import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import qd3.ZootopiaSendArkResult;
import rd3.ShareTarget;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018J4\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H&J:\u0010\u000f\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H&J6\u0010\u0010\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H&J6\u0010\u0011\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H&J8\u0010\u0016\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0014H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/api/IZootopiaShareArkService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lorg/json/JSONObject;", "info", "", "Lrd3/a;", "targets", "Lkotlin/Function1;", "Lqd3/a;", "", "callback", "sendGameArkMessage", "toUsers", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "sendZplanArkMessage", "sendDressArkMessage", "sendShotArkMessage", "", "text", "Lkotlin/Function2;", "", "sendZplanArkMessageToGuild", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZootopiaShareArkService extends QRouteApi {

    @NotNull
    public static final String ARK_EXTRA_INFO_PARAMS = "extInfo";

    @NotNull
    public static final String ARK_MAP_ID = "mapID";

    @NotNull
    public static final String ARK_MAP_INFO = "info";

    @NotNull
    public static final String ARK_MAP_SCENE_TYPE = "sceneType";

    @NotNull
    public static final String ARK_MAP_TEAM_PARAMS = "gameTeamParams";

    @NotNull
    public static final String ARK_TYPE = "arkType";

    @NotNull
    public static final String ARK_TYPE_DRESS = "ark_type_dress";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f329170a;

    @NotNull
    public static final String ZOOTOPIA_ARK_NAME = "com.tencent.zplan.gameshare";

    @NotNull
    public static final String ZOOTOPIA_ARK_NAME_DRESS = "com.tencent.super.squaredress";

    @NotNull
    public static final String ZOOTOPIA_ARK_NAME_SHOT = "com.tencent.super.teaminvite";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/api/IZootopiaShareArkService$a;", "", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f329170a = new Companion();

        Companion() {
        }
    }

    void sendDressArkMessage(@NotNull List<ShareTarget> targets, @Nullable Bundle extraData, @Nullable Function1<? super ZootopiaSendArkResult, Unit> callback);

    void sendGameArkMessage(@NotNull JSONObject info, @NotNull List<ShareTarget> targets, @Nullable Function1<? super ZootopiaSendArkResult, Unit> callback);

    void sendShotArkMessage(@NotNull List<ShareTarget> targets, @Nullable Bundle extraData, @Nullable Function1<? super ZootopiaSendArkResult, Unit> callback);

    void sendZplanArkMessage(@NotNull List<ShareTarget> toUsers, @Nullable Bundle extraData, @Nullable Function1<? super ZootopiaSendArkResult, Unit> callback);

    void sendZplanArkMessageToGuild(@Nullable String text, @Nullable Bundle extraData, @NotNull Function2<? super Integer, ? super String, Unit> callback);
}
