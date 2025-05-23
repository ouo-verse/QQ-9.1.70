package com.tencent.qqnt.textpreview.inject;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J4\u0010\u0013\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/textpreview/inject/e;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "requestCode2", "Landroid/content/Intent;", "data", "", "onActivityResult", "", "content", "atInfo", "flag", "", "peerUin", "ntChatType", "", "c", "text_preview_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface e extends Application.ActivityLifecycleCallbacks {
    @NotNull
    CharSequence c(@Nullable String content, @Nullable String atInfo, int flag, long peerUin, int ntChatType);

    void onActivityResult(@NotNull Activity activity, int requestCode, int requestCode2, @Nullable Intent data);
}
