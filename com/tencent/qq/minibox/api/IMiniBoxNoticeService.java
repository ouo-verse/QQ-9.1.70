package com.tencent.qq.minibox.api;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \f2\u00020\u0001:\u0001\rJ\b\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qq/minibox/api/IMiniBoxNoticeService;", "Lmqq/app/api/IRuntimeService;", "", "checkBannerFromResume", "Landroid/view/View;", "banner", "Landroid/os/Message;", "msg", "updateMiniBoxBar", "Lcom/tencent/qq/minibox/api/data/MiniBoxNoticeInfo;", "noticeInfo", "addGameWaitingNotice", "Companion", "a", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public interface IMiniBoxNoticeService extends IRuntimeService {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f344471a;
    public static final int MSG_GAMECENTER_BAR_HIDE = 1134072;
    public static final int MSG_GAMECENTER_BAR_SHOW = 1134071;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qq/minibox/api/IMiniBoxNoticeService$a;", "", "<init>", "()V", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qq.minibox.api.IMiniBoxNoticeService$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f344471a = new Companion();

        Companion() {
        }
    }

    void addGameWaitingNotice(@NotNull MiniBoxNoticeInfo noticeInfo);

    void checkBannerFromResume();

    void updateMiniBoxBar(@Nullable View banner, @Nullable Message msg2);
}
