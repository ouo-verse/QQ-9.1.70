package com.tencent.ecommerce.biz.hr;

import android.util.Size;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J$\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0011H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/IECHippyRenderView;", "", "onAttach", "", "contextCode", "", "pageName", "params", "", "size", "Landroid/util/Size;", "onDetach", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "sentEvent", AdMetricTag.EVENT_NAME, "data", "", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECHippyRenderView {
    void onAttach(String contextCode, String pageName, Map<String, Object> params, Size size);

    void onDetach();

    void onPause();

    void onResume();

    void sentEvent(String eventName, Map<String, ? extends Object> data);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a {
        public static /* synthetic */ void a(IECHippyRenderView iECHippyRenderView, String str, String str2, Map map, Size size, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    size = null;
                }
                iECHippyRenderView.onAttach(str, str2, map, size);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAttach");
        }
    }
}
