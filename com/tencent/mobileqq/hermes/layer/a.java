package com.tencent.mobileqq.hermes.layer;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerInitBean;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a(\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\n"}, d2 = {"Lcom/tencent/richframework/gallery/RFWLayerLaunchUtil;", "Landroid/content/Context;", "context", "", "currentIndex", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "allMediaInfo", "", "a", "hermes-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class a {
    public static final void a(@NotNull RFWLayerLaunchUtil rFWLayerLaunchUtil, @NotNull Context context, int i3, @NotNull List<? extends RFWLayerItemMediaInfo> allMediaInfo) {
        Intrinsics.checkNotNullParameter(rFWLayerLaunchUtil, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(allMediaInfo, "allMediaInfo");
        Intent intent = new Intent();
        RFWLayerInitBean rFWLayerInitBean = new RFWLayerInitBean();
        rFWLayerInitBean.setEnterPos(i3);
        rFWLayerInitBean.setRichMediaDataList(allMediaInfo);
        intent.putExtra(RFWLaunchKey.KEY_INIT_BEAN, rFWLayerInitBean);
        CompatPublicActivity.Launcher.start(context, intent, CompatPublicActivity.class, HermesCardLayerFragment.class);
    }
}
