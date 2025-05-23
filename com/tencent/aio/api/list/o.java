package com.tencent.aio.api.list;

import android.content.Context;
import android.view.View;
import androidx.annotation.RestrictTo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H'\u00a8\u0006\t"}, d2 = {"Lcom/tencent/aio/api/list/o;", "", "Lcom/tencent/aio/api/list/o$a;", "holder", "", "I", "o", "r", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface o {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0006H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/api/list/o$a;", "", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/aio/api/list/o;", DTConstants.TAG.API, "", "c", "b", "Landroid/content/Context;", "context", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b(@NotNull View rootView, @NotNull o api);

        void c(@NotNull View rootView, @NotNull o api);

        @NotNull
        View createView(@NotNull Context context);
    }

    void I(@NotNull a holder);

    void o();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    void r();
}
