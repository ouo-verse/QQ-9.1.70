package com.tencent.biz.qrcode.util;

import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004J,\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qrcode/util/a;", "", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "source", "qrcodeType", "", "a", "view", "id", "", "elementParams", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f95053a = new a();

    a() {
    }

    public final void a(@NotNull View rootView, @Nullable String source, @NotNull String qrcodeType) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(qrcodeType, "qrcodeType");
        VideoReport.setPageId(rootView, "pg_my_qrcode");
        if (TextUtils.isEmpty(source)) {
            source = "0";
        }
        VideoReport.setPageParams(rootView, "my_qrcode_pg_source", source);
        VideoReport.setPageParams(rootView, "my_qrcode_pg_source_type", qrcodeType);
    }

    public final void b(@NotNull View view, @NotNull String id5, @Nullable Map<String, ? extends Object> elementParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(id5, "id");
        VideoReport.setElementId(view, id5);
        if (elementParams != null) {
            VideoReport.setElementParams(view, elementParams);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }
}
