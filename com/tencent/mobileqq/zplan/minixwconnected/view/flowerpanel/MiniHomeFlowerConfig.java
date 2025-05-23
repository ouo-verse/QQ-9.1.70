package com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel;

import android.graphics.drawable.ColorDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanXWConnectFlowerConfig;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006R\u001b\u0010\u0003\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/MiniHomeFlowerConfig;", "", "Lcom/tencent/sqshow/utils/featureswitch/model/ap;", "flowerConfig", "", "g", "", "url", "b", "c", "f", "e", "Lkotlin/Lazy;", "d", "()Lcom/tencent/sqshow/utils/featureswitch/model/ap;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeFlowerConfig {

    /* renamed from: a, reason: collision with root package name */
    public static final MiniHomeFlowerConfig f334654a = new MiniHomeFlowerConfig();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy flowerConfig;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanXWConnectFlowerConfig>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.MiniHomeFlowerConfig$flowerConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanXWConnectFlowerConfig invoke() {
                ZPlanXWConnectFlowerConfig xWConnectFlowerConfig = ZPlanQQMC.INSTANCE.getXWConnectFlowerConfig();
                QLog.i("MiniHomeFlowerConfig", 1, "config value=" + xWConnectFlowerConfig);
                MiniHomeFlowerConfig.f334654a.g(xWConnectFlowerConfig);
                return xWConnectFlowerConfig;
            }
        });
        flowerConfig = lazy;
    }

    MiniHomeFlowerConfig() {
    }

    private final void b(String url) {
        if (url.length() == 0) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        if (drawable.getStatus() == 1) {
            return;
        }
        drawable.startDownload();
    }

    private final ZPlanXWConnectFlowerConfig d() {
        return (ZPlanXWConnectFlowerConfig) flowerConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(ZPlanXWConnectFlowerConfig flowerConfig2) {
        String f16 = f();
        String e16 = e();
        String experiencePrefixUrl = flowerConfig2.getExperiencePrefixUrl();
        b(experiencePrefixUrl + f16);
        b(experiencePrefixUrl + e16);
        for (int i3 = 0; i3 < 10; i3++) {
            b(experiencePrefixUrl + "_" + i3 + ".png");
            StringBuilder sb5 = new StringBuilder();
            sb5.append(experiencePrefixUrl);
            sb5.append(i3);
            sb5.append(".png");
            b(sb5.toString());
        }
    }

    public final ZPlanXWConnectFlowerConfig c() {
        return d();
    }

    public final String e() {
        return "negative.png";
    }

    public final String f() {
        return "positive.png";
    }
}
