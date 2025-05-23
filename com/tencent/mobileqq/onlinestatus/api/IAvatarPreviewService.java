package com.tencent.mobileqq.onlinestatus.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.onlinestatus.avatar.GetUrlResult;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.weiyun.transmission.db.JobDbManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Service(process = {""})
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J5\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022#\u0010\n\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H&JP\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r26\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u000fH&J;\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\u0004H&J;\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\u0004H&J;\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\u0004H&J\b\u0010\u0017\u001a\u00020\tH&JU\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\f2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0002\u0010\u001b\u001a\u00020\rH&JR\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000228\u0010\n\u001a4\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\t0\u000fH&\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/api/IAvatarPreviewService;", "Lmqq/app/api/IRuntimeService;", "", "uin", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/onlinestatus/avatar/a;", "Lkotlin/ParameterName;", "name", "result", "", "callback", "getUrl", "", "", "onlineStatusId", "Lkotlin/Function2;", "", "success", "exist", "isUrlExist", "addUrl", "keepUrl", JobDbManager.TBL_UPLOAD, "clearPreviewDir", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "dressKey", "subIndex", "uploadPreview", "type", ZPlanPublishSource.FROM_SCHEME, "getStatusJumpScheme", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface IAvatarPreviewService extends IRuntimeService {
    void addUrl(@NotNull String uin, int onlineStatusId, @NotNull Function1<? super Boolean, Unit> callback);

    void clearPreviewDir();

    void getStatusJumpScheme(long uin, long type, @NotNull Function2<? super Boolean, ? super String, Unit> callback);

    void getUrl(long uin, @NotNull Function1<? super GetUrlResult, Unit> callback);

    void isUrlExist(@NotNull String uin, int onlineStatusId, @NotNull Function2<? super Boolean, ? super Boolean, Unit> callback);

    void keepUrl(@NotNull String uin, int onlineStatusId, @NotNull Function1<? super Boolean, Unit> callback);

    void upload(@NotNull String uin, int onlineStatusId, @NotNull Function1<? super Boolean, Unit> callback);

    void uploadPreview(@NotNull BaseQQAppInterface app, @NotNull String uin, int onlineStatusId, @NotNull String dressKey, @NotNull Function1<? super Boolean, Unit> callback, int subIndex);
}
