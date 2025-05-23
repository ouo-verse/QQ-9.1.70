package com.tencent.mobileqq.gamecenter.utils;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.gamecenter.data.GameReportExtraData;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterRobotReport$ExtParam;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/utils/j;", "", "Lcom/tencent/mobileqq/gamecenter/data/i;", WadlProxyConsts.EXTRA_DATA, "", "Lcom/tencent/mobileqq/gamecenter/trpcprotocol/GameCenterRobotReport$ExtParam;", "a", "", "key", "value", "b", "<init>", "()V", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f213443a = new j();

    j() {
    }

    @JvmStatic
    @NotNull
    public static final List<GameCenterRobotReport$ExtParam> a(@NotNull GameReportExtraData extraData) {
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        ArrayList arrayList = new ArrayList();
        if (extraData.getExt1() != null) {
            arrayList.add(f213443a.b("ext1", extraData.getExt1()));
        }
        if (extraData.getExt2() != null) {
            arrayList.add(f213443a.b("ext2", extraData.getExt2()));
        }
        if (extraData.getExt3() != null) {
            arrayList.add(f213443a.b("ext3", extraData.getExt3()));
        }
        if (extraData.getExt6() != null) {
            arrayList.add(f213443a.b("ext6", extraData.getExt6()));
        }
        if (extraData.getExt9() != null) {
            arrayList.add(f213443a.b("ext9", extraData.getExt9()));
        }
        if (extraData.getExt10() != null) {
            arrayList.add(f213443a.b("ext10", extraData.getExt10()));
        }
        if (extraData.getExt11() != null) {
            arrayList.add(f213443a.b("ext11", extraData.getExt11()));
        }
        if (extraData.getExt12() != null) {
            arrayList.add(f213443a.b("ext12", extraData.getExt12()));
        }
        if (extraData.getExt26() != null) {
            arrayList.add(f213443a.b("ext26", extraData.getExt26()));
        }
        if (extraData.getGameAppId() != null) {
            arrayList.add(f213443a.b(WadlReportBuilder.TableElem.GAME_APPID, extraData.getGameAppId()));
        }
        return arrayList;
    }

    private final GameCenterRobotReport$ExtParam b(String key, String value) {
        GameCenterRobotReport$ExtParam gameCenterRobotReport$ExtParam = new GameCenterRobotReport$ExtParam();
        gameCenterRobotReport$ExtParam.name.set(key);
        gameCenterRobotReport$ExtParam.val.set(value);
        return gameCenterRobotReport$ExtParam;
    }
}
