package com.tencent.mobileqq.vas.api;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\fH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/api/a;", "", "", "param", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "width", "height", "", "a", "onDestory", "Landroid/view/View;", "getView", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface a {
    void a(@NotNull String param, @NotNull Activity activity, int width, int height);

    @NotNull
    View getView();

    void onDestory();
}
