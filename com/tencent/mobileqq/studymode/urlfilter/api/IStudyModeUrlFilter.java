package com.tencent.mobileqq.studymode.urlfilter.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/studymode/urlfilter/api/IStudyModeUrlFilter;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "initUrlFilterFlagFirstEnter", "", "openUrlFilterMainFragment", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "registerStudyModeSetting", "registerThreadMessage", "urlFilterCheckedSupportOpen", "", "url", "", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IStudyModeUrlFilter extends QRouteApi {
    void initUrlFilterFlagFirstEnter();

    void openUrlFilterMainFragment(@Nullable Context context, @Nullable Intent intent);

    void registerStudyModeSetting();

    void registerThreadMessage();

    boolean urlFilterCheckedSupportOpen(@Nullable String url);
}
