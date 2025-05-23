package com.tencent.qqnt.kernel.api;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.qqnt.kernel.nativeinterface.AiAvatarActionStatus;
import com.tencent.qqnt.kernel.nativeinterface.CoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetAiAvatarCategoryInfosReq;
import com.tencent.qqnt.kernel.nativeinterface.IDetailInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetAiAvatarCategoryInfosCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.Intimate;
import com.tencent.qqnt.kernel.nativeinterface.OtherFlag;
import com.tencent.qqnt.kernel.nativeinterface.ProfileBizType;
import com.tencent.qqnt.kernel.nativeinterface.RelationFlag;
import com.tencent.qqnt.kernel.nativeinterface.Source;
import com.tencent.qqnt.kernel.nativeinterface.StatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.StockLocalData;
import com.tencent.qqnt.kernel.nativeinterface.UserSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.VasInfo;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J2\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000fj\b\u0012\u0004\u0012\u00020\b`\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\"\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\rH&J6\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\b2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000fj\b\u0012\u0004\u0012\u00020\b`\u0010H&J6\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\b2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000fj\b\u0012\u0004\u0012\u00020\b`\u0010H&J:\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\b2\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u0010H&J:\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020 \u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\b2\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u0010H&J:\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\"\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\b2\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u0010H&J,\u0010&\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\b2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\"0\u00192\u0006\u0010%\u001a\u00020\nH&J6\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020'\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\b2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000fj\b\u0012\u0004\u0012\u00020\b`\u0010H&J2\u0010*\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020)\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH&J4\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020+0\u00192\u0006\u0010\u0018\u001a\u00020\b2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000fj\b\u0012\u0004\u0012\u00020\b`\u0010H&J4\u0010.\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u0018\u001a\u00020\b2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020+0\u000fj\b\u0012\u0004\u0012\u00020+`\u0010H&J \u00101\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\b2\u0006\u00100\u001a\u00020/2\u0006\u0010%\u001a\u00020\nH&JR\u00108\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\b2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000fj\b\u0012\u0004\u0012\u00020\b`\u00102\u0006\u00103\u001a\u0002022\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u0002040\u000fj\b\u0012\u0004\u0012\u000204`\u00102\b\u00107\u001a\u0004\u0018\u000106H&J6\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u000209\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\b2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000fj\b\u0012\u0004\u0012\u00020\b`\u0010H&J\"\u0010@\u001a\u00020\u00042\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\r2\b\u0010?\u001a\u0004\u0018\u00010>H&J*\u0010C\u001a\u00020\u00042\u0016\u0010B\u001a\u0012\u0012\u0004\u0012\u00020A0\u000fj\b\u0012\u0004\u0012\u00020A`\u00102\b\u0010?\u001a\u0004\u0018\u00010\nH&\u00a8\u0006D"}, d2 = {"Lcom/tencent/qqnt/kernel/api/y;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelProfileListener;", "listener", "", "r0", "addKernelProfileListenerForUICache", "D0", "", "nick", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "cb", "l0", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uids", "getUserSimpleInfo", "uid", "forceRefresh", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "isForceReset", "startStatusPolling", "callFrom", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/UserSimpleInfo;", "getCoreAndBaseInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/RelationFlag;", "getRelationFlag", "Lcom/tencent/qqnt/kernel/nativeinterface/VasInfo;", "getVasInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/Intimate;", "getIntimate", "Lcom/tencent/qqnt/kernel/nativeinterface/StockLocalData;", "getStockLocalData", "data", "callBack", "updateStockLocalData", "Lcom/tencent/qqnt/kernel/nativeinterface/StatusInfo;", "getStatusInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/OtherFlag;", "getOtherFlag", "", "getUinByUid", "uin", "getUidByUin", "", "pb", "updateProfileData", "Lcom/tencent/qqnt/kernel/nativeinterface/Source;", "source", "Lcom/tencent/qqnt/kernel/nativeinterface/ProfileBizType;", "bizList", "Lcom/tencent/qqnt/kernel/nativeinterface/IDetailInfoCallback;", "result", "fetchUserDetailInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CoreInfo;", "getCoreInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAiAvatarCategoryInfosReq;", "req", "forceFetch", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAiAvatarCategoryInfosCallback;", "callback", "getAiAvatarCategoryInfos", "Lcom/tencent/qqnt/kernel/nativeinterface/AiAvatarActionStatus;", "actions", "setAiAvatarActionStatus", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface y extends j {
    void D0(@NotNull IKernelProfileListener listener);

    void addKernelProfileListenerForUICache(@NotNull IKernelProfileListener listener);

    void fetchUserDetailInfo(@NotNull String callFrom, @NotNull ArrayList<String> uid, @NotNull Source source, @NotNull ArrayList<ProfileBizType> bizList, @Nullable IDetailInfoCallback result);

    void getAiAvatarCategoryInfos(@NotNull GetAiAvatarCategoryInfosReq req, boolean forceFetch, @Nullable IGetAiAvatarCategoryInfosCallback callback);

    @Nullable
    HashMap<String, UserSimpleInfo> getCoreAndBaseInfo(@NotNull String callFrom, @NotNull ArrayList<String> uids);

    @Nullable
    HashMap<String, CoreInfo> getCoreInfo(@NotNull String callFrom, @NotNull ArrayList<String> uids);

    @Nullable
    HashMap<String, Intimate> getIntimate(@NotNull String callFrom, @Nullable ArrayList<String> uids);

    @Nullable
    HashMap<String, OtherFlag> getOtherFlag(@Nullable String callFrom, @Nullable ArrayList<String> uids);

    @Nullable
    HashMap<String, RelationFlag> getRelationFlag(@NotNull String callFrom, @NotNull ArrayList<String> uids);

    void getStatus(@NotNull String uid, boolean forceRefresh, @Nullable IOperateCallback cb5);

    @Nullable
    HashMap<String, StatusInfo> getStatusInfo(@NotNull String callFrom, @NotNull ArrayList<String> uids);

    @Nullable
    HashMap<String, StockLocalData> getStockLocalData(@NotNull String callFrom, @Nullable ArrayList<String> uids);

    @NotNull
    HashMap<Long, String> getUidByUin(@NotNull String callFrom, @NotNull ArrayList<Long> uin);

    @NotNull
    HashMap<String, Long> getUinByUid(@NotNull String callFrom, @NotNull ArrayList<String> uids);

    void getUserSimpleInfo(boolean force, @NotNull ArrayList<String> uids, @Nullable IOperateCallback cb5);

    @Nullable
    HashMap<String, VasInfo> getVasInfo(@NotNull String callFrom, @Nullable ArrayList<String> uids);

    void l0(@NotNull String nick, @Nullable IOperateCallback cb5);

    void r0(@NotNull IKernelProfileListener listener);

    void setAiAvatarActionStatus(@NotNull ArrayList<AiAvatarActionStatus> actions, @Nullable IOperateCallback callback);

    void startStatusPolling(boolean isForceReset);

    void updateProfileData(@NotNull String callFrom, @NotNull byte[] pb5, @NotNull IOperateCallback callBack);

    boolean updateStockLocalData(@NotNull String callFrom, @NotNull HashMap<String, StockLocalData> data, @NotNull IOperateCallback callBack);
}
