package com.tencent.mobileqq.nearbypro.api;

import android.view.View;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Service(process = {""})
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/INearbyProAvatarService;", "Lmqq/app/api/IRuntimeService;", "loadAvatarForTinyId", "", "avatarView", "Landroid/view/View;", "tid", "", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public interface INearbyProAvatarService extends IRuntimeService {
    void loadAvatarForTinyId(@NotNull View avatarView, long tid);
}
