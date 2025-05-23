package com.tencent.mobileqq.zplan.api;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uv4.al;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZPlanDebugHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "isUploadAvatarChecked", "", "avatarString", "cacheDirPath", "", "zipAndUploadAvatarJsonToWorkChat", "Luv4/al;", "currentAvatar", "Ldw4/b;", "result", "shareAvatarCharacterIfNeed", "Landroid/content/Context;", "context", "jumpToZPlanDebugFragment", "Landroid/widget/TextView;", "tv", "tryShowLongTextForTemplate", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanDebugHelper extends QRouteApi {
    boolean isUploadAvatarChecked();

    void jumpToZPlanDebugFragment(@NotNull Context context);

    void shareAvatarCharacterIfNeed(@NotNull al currentAvatar, @NotNull dw4.b result);

    void tryShowLongTextForTemplate(@Nullable TextView tv5);

    void zipAndUploadAvatarJsonToWorkChat(@NotNull String avatarString, @NotNull String cacheDirPath);
}
