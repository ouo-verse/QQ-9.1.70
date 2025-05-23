package com.tencent.qqnt.aio.adapter.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001Jc\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022)\u0010\u0010\u001a%\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tj\u0004\u0018\u0001`\u000fH&JY\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tj\u0004\u0018\u0001`\u0015H&JS\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022/\u0010\u0010\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0017\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tj\u0004\u0018\u0001`\u0019H&J$\u0010\u001c\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H&\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/INtTroopMemberApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "troopUin", "memberUid", "", "needColorName", "needRemark", "from", "Lkotlin/Function1;", "Lcom/tencent/qqnt/aio/adapter/troop/a;", "Lkotlin/ParameterName;", "name", "nickInfo", "", "Lcom/tencent/qqnt/aio/adapter/api/IFetchTroopMemberNameCallback;", "callback", "fetchTroopMemberName", "forceNet", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "memberInfo", "Lcom/tencent/qqnt/aio/adapter/api/IFetchTroopMemberInfoCallback;", "fetchTroopMemberInfo", "", "memberInfoList", "Lcom/tencent/qqnt/aio/adapter/api/IFetchTroopMemberListCallback;", "fetchTroopMemberList", "needColorNick", "getShowName", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes23.dex */
public interface INtTroopMemberApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static /* synthetic */ void a(INtTroopMemberApi iNtTroopMemberApi, String str, String str2, boolean z16, boolean z17, String str3, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                boolean z18 = z16;
                if ((i3 & 8) != 0) {
                    z17 = true;
                }
                iNtTroopMemberApi.fetchTroopMemberName(str, str2, z18, z17, str3, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchTroopMemberName");
        }
    }

    void fetchTroopMemberInfo(@Nullable String troopUin, @Nullable String memberUid, boolean forceNet, @NotNull String from, @Nullable Function1<? super MemberInfo, Unit> callback);

    void fetchTroopMemberList(@Nullable String troopUin, boolean forceNet, @NotNull String from, @Nullable Function1<? super List<MemberInfo>, Unit> callback);

    void fetchTroopMemberName(@Nullable String troopUin, @Nullable String memberUid, boolean needColorName, boolean needRemark, @NotNull String from, @Nullable Function1<? super com.tencent.qqnt.aio.adapter.troop.a, Unit> callback);

    @NotNull
    String getShowName(@NotNull com.tencent.qqnt.aio.adapter.troop.a nickInfo, boolean needColorNick, boolean needRemark);
}
