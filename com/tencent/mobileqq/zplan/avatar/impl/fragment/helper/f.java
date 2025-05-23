package com.tencent.mobileqq.zplan.avatar.impl.fragment.helper;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.zootopia.scene.data.SceneInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J,\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u0010\u001a\u00020\u0006R\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/helper/f;", "", "Landroid/os/Bundle;", "arguments", "Landroid/content/Intent;", "intent", "", "d", "", "c", "", "rootSourceId", "Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "cameraId", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "a", "b", "I", "currentViewType", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int currentViewType;

    private final int d(Bundle arguments, Intent intent) {
        int i3 = arguments != null ? arguments.getInt("sceneType", 0) : 0;
        if (i3 <= 0) {
            String string = arguments != null ? arguments.getString("ueParams", null) : null;
            if (TextUtils.isEmpty(string)) {
                JSONObject j3 = xb4.b.f447772a.j(intent != null ? intent.getExtras() : null);
                string = j3 != null ? j3.toString() : null;
            }
            if (string == null || string.length() == 0) {
                return 1;
            }
            i3 = new JSONObject(string).optInt("sceneType", 1);
        }
        this.currentViewType = i3;
        return i3;
    }

    public final SceneInfo a(String rootSourceId, Bundle arguments, Intent intent, CameraKey cameraId) {
        Intrinsics.checkNotNullParameter(rootSourceId, "rootSourceId");
        int i3 = this.currentViewType;
        if (i3 == 0) {
            i3 = d(arguments, intent);
        }
        String string = arguments != null ? arguments.getString("ueParams", null) : null;
        if (TextUtils.isEmpty(string)) {
            JSONObject j3 = xb4.b.f447772a.j(intent != null ? intent.getExtras() : null);
            string = j3 != null ? j3.toString() : null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string == null ? "{}" : string);
            jSONObject.put("Source", rootSourceId);
            string = jSONObject.toString();
        } catch (JSONException e16) {
            QLog.e("ZPlanUESceneParser_", 1, "getSceneParams failed", e16);
        }
        SceneInfo.Companion companion = SceneInfo.INSTANCE;
        if (string == null) {
            string = "{}";
        }
        String a16 = companion.a(string, "NativePageHash", "ZPlanUESceneParser-" + hashCode());
        if (cameraId != null) {
            a16 = companion.a(a16 != null ? a16 : "{}", "InitCameraConfig", r94.c.u(j94.a.f409675a.b(cameraId)));
        }
        QLog.i("ZPlanUESceneParser_", 1, "sceneType:" + i3 + ", paramStr:" + a16);
        return new SceneInfo(i3, a16);
    }

    /* renamed from: b, reason: from getter */
    public final int getCurrentViewType() {
        return this.currentViewType;
    }

    public final void c(Bundle arguments, Intent intent) {
        d(arguments, intent);
        QLog.i("ZPlanUESceneParser_", 1, "init currentViewType:" + this.currentViewType);
    }
}
