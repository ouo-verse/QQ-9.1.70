package com.tencent.imcore.message.facade.unread.filter;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u000b\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/imcore/message/facade/unread/filter/x;", "", "Lorg/json/JSONObject;", "jsonConf", "Lcom/tencent/imcore/message/facade/unread/filter/w;", DownloadInfo.spKey_Config, "", "c", "jsonObject", "Lcom/tencent/imcore/message/facade/unread/filter/c;", "a", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class x {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final x f116653a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22354);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f116653a = new x();
        }
    }

    x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final c a(JSONObject jsonObject) {
        if (jsonObject != null) {
            int optInt = jsonObject.optInt("type", Integer.MIN_VALUE);
            String uin = jsonObject.optString("uin", "");
            if (optInt != Integer.MIN_VALUE && !TextUtils.isEmpty(uin)) {
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                return new c(optInt, uin);
            }
            return null;
        }
        return null;
    }

    private final void c(JSONObject jsonConf, w config) {
        JSONArray optJSONArray = jsonConf.optJSONArray("filter_uin_type");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                int optInt = optJSONArray.optInt(i3, Integer.MIN_VALUE);
                if (optInt != Integer.MIN_VALUE) {
                    arrayList.add(Integer.valueOf(optInt));
                }
            }
            config.b(arrayList);
        }
        JSONArray optJSONArray2 = jsonConf.optJSONArray("filter_conv");
        if (optJSONArray2 != null && optJSONArray2.length() != 0) {
            SparseArray<ArrayList<c>> sparseArray = new SparseArray<>();
            int length2 = optJSONArray2.length();
            for (int i16 = 0; i16 < length2; i16++) {
                c a16 = f116653a.a(optJSONArray2.optJSONObject(i16));
                if (a16 != null) {
                    ArrayList<c> arrayList2 = sparseArray.get(a16.a());
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                        sparseArray.put(a16.a(), arrayList2);
                    }
                    arrayList2.add(a16);
                }
            }
            config.a(sparseArray);
        }
    }

    @NotNull
    public final w b() {
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (w) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        w wVar = new w(false, null, null, 6, null);
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            return wVar;
        }
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026ava, ProcessConstant.ALL)");
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) runtimeService;
        boolean isFeatureSwitchEnable = iFeatureRuntimeService.isFeatureSwitchEnable("android_unread_filter_config");
        wVar.c(isFeatureSwitchEnable);
        if (!isFeatureSwitchEnable) {
            return wVar;
        }
        JSONObject jSONObject = iFeatureRuntimeService.getJSONObject("android_unread_filter_config", "");
        if (jSONObject == null) {
            return wVar;
        }
        try {
            c(jSONObject, wVar);
        } catch (Exception e16) {
            QLog.e("UnreadFilterConfigParser", 1, "parse config error", e16);
        }
        QLog.i("UnreadFilterConfigParser", 1, "parse config: " + wVar);
        return wVar;
    }
}
