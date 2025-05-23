package cooperation.vip.ad;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcooperation/vip/ad/GrowHalfLayerHippyFragment;", "Lcom/tencent/hippy/qq/fragment/BaseHippyFragment;", "()V", "doBussinessInitData", "Lorg/json/JSONObject;", "jsInitData", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class GrowHalfLayerHippyFragment extends BaseHippyFragment {
    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment
    @Nullable
    protected JSONObject doBussinessInitData(@Nullable JSONObject jsInitData) {
        SerializableMap serializableMap;
        try {
            Bundle parameters = getParameters();
            if (parameters != null) {
                Serializable serializable = parameters.getSerializable(OpenHippyInfo.EXTRA_KEY_JS_PARAM_MAP);
                if (serializable instanceof SerializableMap) {
                    serializableMap = (SerializableMap) serializable;
                } else {
                    serializableMap = null;
                }
                if (serializableMap != null) {
                    JSONObject wrapHashMap = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).wrapHashMap(jsInitData, serializableMap.getMap());
                    if (wrapHashMap != null) {
                        return wrapHashMap;
                    }
                    return jsInitData;
                }
            }
        } catch (Throwable th5) {
            QLog.e("BaseHippyFragment", 1, "doBussinessInitData eror", th5);
        }
        return jsInitData;
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Context context;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        FrameLayout frameLayout = null;
        if (container != null) {
            context = container.getContext();
        } else {
            context = null;
        }
        if (context != null) {
            frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            loadHippy(frameLayout);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }
}
