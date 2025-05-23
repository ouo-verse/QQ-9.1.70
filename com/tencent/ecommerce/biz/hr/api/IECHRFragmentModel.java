package com.tencent.ecommerce.biz.hr.api;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052%\u0010\u0006\u001a!\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00030\u0007j\u0002`\fH&J\b\u0010\r\u001a\u00020\u0003H&J$\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0012H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/api/IECHRFragmentModel;", "", "getFragment", "", "bundle", "Landroid/os/Bundle;", "getFragmentCallback", "Lkotlin/Function1;", "Landroidx/fragment/app/Fragment;", "Lkotlin/ParameterName;", "name", "fragment", "Lcom/tencent/ecommerce/biz/hr/api/GetFragmentCallback;", "manualOnStop", "sendEvent", AdMetricTag.EVENT_NAME, "", "data", "", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECHRFragmentModel {
    void getFragment(@NotNull Bundle bundle, @NotNull Function1<? super Fragment, Unit> getFragmentCallback);

    void manualOnStop();

    void sendEvent(@NotNull String eventName, @NotNull Map<String, ? extends Object> data);
}
