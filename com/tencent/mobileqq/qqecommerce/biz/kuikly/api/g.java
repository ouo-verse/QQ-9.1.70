package com.tencent.mobileqq.qqecommerce.biz.kuikly.api;

import android.content.Intent;
import android.util.Size;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import cooperation.qzone.QzoneIPCModule;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J0\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\f\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0006H&J\b\u0010\u000e\u001a\u00020\u0006H&J$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0010H&J\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u0016H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&R\u0014\u0010\u001d\u001a\u00020\u001a8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "", "", ZPlanPublishSource.FROM_SCHEME, "Landroid/util/Size;", "size", "", "d", "pageName", "", "params", "b", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "onDetach", AdMetricTag.EVENT_NAME, "", "data", "sentEvent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "onActivityResult", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "c", "Ll01/a;", "a", "()Ll01/a;", "unitConverter", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface g {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a {
        public static /* synthetic */ void a(g gVar, String str, Size size, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    size = null;
                }
                gVar.d(str, size);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAttach");
        }

        public static /* synthetic */ void b(g gVar, String str, Map map, Size size, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    size = null;
                }
                gVar.b(str, map, size);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAttach");
        }
    }

    @NotNull
    l01.a a();

    void b(@NotNull String pageName, @NotNull Map<String, Object> params, @Nullable Size size);

    @Nullable
    h c();

    void d(@NotNull String scheme, @Nullable Size size);

    void onActivityResult(int requestCode, int resultCode, @Nullable Intent data);

    void onDetach();

    void onPause();

    void onResume();

    void sentEvent(@NotNull String eventName, @NotNull Map<String, ? extends Object> data);
}
