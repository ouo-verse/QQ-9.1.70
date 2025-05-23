package com.tencent.mobileqq.onlinestatus.api;

import com.tencent.mobileqq.onlinestatus.model.f;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.state.data.SquareJSConst;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\bg\u0018\u0000 !2\u00020\u0001:\u0001\"J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J+\u0010\r\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H&J+\u0010\u000e\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H&J3\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00072!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H&JP\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H&\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\u000bH&J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0004H&J3\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00072!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H&JJ\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000228\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000b0\u001aH&JZ\u0010\u001b\u001a\u00020\u000b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2B\u0010\f\u001a>\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00040\u001f\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u000b0\u001aH&\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/api/IOnlineStatusAvatarSwitchService;", "Lmqq/app/api/IRuntimeService;", "", "uin", "Lcom/tencent/mobileqq/onlinestatus/model/f;", "getSwitchStatus", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "callback", "setSelfAutoWhitelistOn", "setSelfAutoWhitelistOff", "on", "setSelfGrayWhitelistSwitch", "panelSwitch", "autoWhite", "grayWhite", "setSwitchStatus", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;)V", "resetAllSwitch", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "onSwitchUpdated", "setSelfPanelSwitch", "Lkotlin/Function2;", "updateFriendSwitchStatus", "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "", "switchMap", "Companion", "a", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface IOnlineStatusAvatarSwitchService extends IRuntimeService {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f255423a;
    public static final int SWITCH_ID = 47171;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/api/IOnlineStatusAvatarSwitchService$a;", "", "<init>", "()V", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f255423a = new Companion();

        Companion() {
        }
    }

    @Nullable
    f getSwitchStatus(@NotNull String uin);

    void onSwitchUpdated(@NotNull String uin, @NotNull f r26);

    void resetAllSwitch();

    void setSelfAutoWhitelistOff(@NotNull Function1<? super Boolean, Unit> callback);

    void setSelfAutoWhitelistOn(@NotNull Function1<? super Boolean, Unit> callback);

    void setSelfGrayWhitelistSwitch(boolean on5, @NotNull Function1<? super Boolean, Unit> callback);

    void setSelfPanelSwitch(boolean on5, @NotNull Function1<? super Boolean, Unit> callback);

    void setSwitchStatus(@Nullable Boolean panelSwitch, @Nullable Boolean autoWhite, @Nullable Boolean grayWhite, @NotNull Function1<? super Boolean, Unit> callback);

    void updateFriendSwitchStatus(@NotNull String uin, @NotNull Function2<? super Boolean, ? super f, Unit> callback);

    void updateFriendSwitchStatus(@NotNull List<Long> uinList, @NotNull Function2<? super Boolean, ? super Map<Long, f>, Unit> callback);
}
