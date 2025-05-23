package com.tencent.mobileqq.qqecommerce.biz.hr.api;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007H&J$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\fH&J\b\u0010\u000f\u001a\u00020\u0006H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/d;", "", "Landroid/os/Bundle;", "bundle", "Lkotlin/Function1;", "Landroidx/fragment/app/Fragment;", "", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/QQHRFragmentCallback;", "callback", "getFragment", "", AdMetricTag.EVENT_NAME, "", "data", "sendEvent", "manualOnStop", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface d {
    void getFragment(@NotNull Bundle bundle, @NotNull Function1<? super Fragment, Unit> callback);

    void manualOnStop();

    void sendEvent(@NotNull String eventName, @NotNull Map<String, ? extends Object> data);
}
