package com.tencent.mobileqq.zplan.avatar.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Service(process = {"all"})
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001JT\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\rH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/api/IZPlanAvatarUploadService;", "Lmqq/app/api/IRuntimeService;", "requestUploadAvatar", "", "staticFilePath", "", "outboundFilePath", "bgId", "", "bgUrl", "clipPercent", "configId", "callback", "Lkotlin/Function1;", "", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public interface IZPlanAvatarUploadService extends IRuntimeService {
    void requestUploadAvatar(@Nullable String staticFilePath, @Nullable String outboundFilePath, int bgId, @Nullable String bgUrl, int clipPercent, @Nullable String configId, @NotNull Function1<? super Boolean, Unit> callback);
}
