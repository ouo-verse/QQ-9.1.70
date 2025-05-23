package com.tencent.qqnt.kernel.api;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqnt.kernel.nativeinterface.AvatarUrlType;
import com.tencent.qqnt.kernel.nativeinterface.BuddyListCategory;
import com.tencent.qqnt.kernel.nativeinterface.BuddyListReqType;
import com.tencent.qqnt.kernel.nativeinterface.DelBuddyInfo;
import com.tencent.qqnt.kernel.nativeinterface.IBuddyListCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICheckIsBuddyCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener;
import com.tencent.qqnt.kernel.nativeinterface.IModifyCategoryCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RemarkParams;
import com.tencent.qqnt.kernel.nativeinterface.SpecialCareSetting;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&J*\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0010H&J.\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u00152\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0012j\b\u0012\u0004\u0012\u00020\f`\u0013H&J.\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u00152\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0012j\b\u0012\u0004\u0012\u00020\f`\u0013H&J\u001c\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\n\u001a\u0004\u0018\u00010\tH&J6\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u00152\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0012j\b\u0012\u0004\u0012\u00020\f`\u00132\u0006\u0010\u001c\u001a\u00020\u001bH&J\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\fH&\u00a2\u0006\u0004\b\u001f\u0010 J6\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00152\u0006\u0010\r\u001a\u00020\f2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0012j\b\u0012\u0004\u0012\u00020\f`\u0013H&J\u001c\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J$\u0010'\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u00020%2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J&\u0010,\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\f2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\n\u001a\u0004\u0018\u00010+H&J\u001a\u0010-\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\"\u00101\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u00010\tH&J\"\u00103\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\f2\u0006\u00102\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010\tH&J\"\u00105\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\f2\u0006\u00104\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010\tH&J\"\u00107\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\f2\u0006\u00106\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010\tH&J \u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u00108\u001a\u00020\u000eH&J\b\u0010;\u001a\u00020\u0007H&J\"\u0010>\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010<\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u00010=H&J\b\u0010?\u001a\u00020%H&\u00a8\u0006@"}, d2 = {"Lcom/tencent/qqnt/kernel/api/m;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBuddyListener;", "listener", "", "I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "cb", "getBuddyList", "", "callFrom", "Lcom/tencent/qqnt/kernel/nativeinterface/BuddyListReqType;", "requestType", "Lcom/tencent/qqnt/kernel/nativeinterface/IBuddyListCallback;", "getBuddyListV2", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uids", "", "getBuddyNick", "getBuddyRemark", "Lcom/tencent/qqnt/kernel/nativeinterface/RemarkParams;", "remarkParams", "setBuddyRemark", "Lcom/tencent/qqnt/kernel/nativeinterface/AvatarUrlType;", "type", "g", "uid", "isBuddy", "(Ljava/lang/String;)Ljava/lang/Boolean;", "areBuddies", "Lcom/tencent/qqnt/kernel/nativeinterface/DelBuddyInfo;", "delInfo", "delBuddy", "", "categoryId", "setBuddyCategory", "name", "", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/IModifyCategoryCallback;", "addCategoryV2", "delCategory", "Lcom/tencent/qqnt/kernel/nativeinterface/SpecialCareSetting;", "set", "result", "L", "noDisturb", "setMsgNotify", "block", "setBlock", "isTop", "setTop", "reqType", "Lcom/tencent/qqnt/kernel/nativeinterface/BuddyListCategory;", "getBuddyListFromCache", "H0", "tag", "Lcom/tencent/qqnt/kernel/nativeinterface/ICheckIsBuddyCallback;", BdhLogUtil.LogTag.Tag_Req, "getAllBuddyCount", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface m extends j {
    void A(@NotNull IKernelBuddyListener listener);

    boolean H0();

    void I(@NotNull IKernelBuddyListener listener);

    void L(@NotNull String uid, @NotNull SpecialCareSetting set, @Nullable IOperateCallback result);

    void R(@NotNull String uid, @NotNull String tag, @Nullable ICheckIsBuddyCallback result);

    void addCategoryV2(@Nullable String name, @Nullable byte[] context, @Nullable IModifyCategoryCallback cb5);

    @Nullable
    Map<String, Boolean> areBuddies(@NotNull String callFrom, @NotNull ArrayList<String> uids);

    void delBuddy(@Nullable DelBuddyInfo delInfo, @Nullable IOperateCallback cb5);

    void delCategory(int categoryId, @Nullable IOperateCallback cb5);

    @Nullable
    Map<String, String> g(@NotNull ArrayList<String> uids, @NotNull AvatarUrlType type);

    int getAllBuddyCount();

    void getBuddyList(boolean force, @Nullable IOperateCallback cb5);

    @Nullable
    ArrayList<BuddyListCategory> getBuddyListFromCache(@NotNull String callFrom, @NotNull BuddyListReqType reqType);

    void getBuddyListV2(@NotNull String callFrom, boolean force, @NotNull BuddyListReqType requestType, @Nullable IBuddyListCallback cb5);

    @Nullable
    Map<String, String> getBuddyNick(@NotNull ArrayList<String> uids);

    @Nullable
    Map<String, String> getBuddyRemark(@NotNull ArrayList<String> uids);

    @Nullable
    Boolean isBuddy(@NotNull String uid);

    void setBlock(@NotNull String uid, boolean block, @Nullable IOperateCallback result);

    void setBuddyCategory(@Nullable String uid, int categoryId, @Nullable IOperateCallback cb5);

    void setBuddyRemark(@Nullable RemarkParams remarkParams, @Nullable IOperateCallback cb5);

    void setMsgNotify(@NotNull String uid, boolean noDisturb, @Nullable IOperateCallback result);

    void setTop(@NotNull String uid, boolean isTop, @Nullable IOperateCallback result);
}
