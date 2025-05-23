package com.tencent.mobileqq.troop.troopcreate.classify;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0002R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR&\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/classify/b;", "", "Landroid/widget/LinearLayout;", "troopClassifyLayout", "", "a", "b", "", "Ljava/lang/Integer;", "curConfigVersion", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/troopcreate/classify/a;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "curConfigClassifyList", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f300039a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Integer curConfigVersion;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ArrayList<a> curConfigClassifyList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25141);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f300039a = new b();
            curConfigClassifyList = new ArrayList<>();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull LinearLayout troopClassifyLayout) {
        TroopCreateClassifyOutItemView troopCreateClassifyOutItemView;
        Intrinsics.checkNotNullParameter(troopClassifyLayout, "troopClassifyLayout");
        f300039a.b();
        if (curConfigClassifyList.isEmpty()) {
            troopClassifyLayout.setVisibility(8);
            return;
        }
        if (troopClassifyLayout.getChildCount() != curConfigClassifyList.size()) {
            troopClassifyLayout.removeAllViews();
            if (curConfigClassifyList.size() < 4) {
                int size = curConfigClassifyList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Context context = troopClassifyLayout.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "troopClassifyLayout.context");
                    troopClassifyLayout.addView(new TroopCreateClassifyOutItemView(context, null, 0, 6, null), new LinearLayout.LayoutParams(ViewUtils.dpToPx(84.0f), -1));
                }
            } else {
                int size2 = curConfigClassifyList.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    Context context2 = troopClassifyLayout.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "troopClassifyLayout.context");
                    View troopCreateClassifyOutItemView2 = new TroopCreateClassifyOutItemView(context2, null, 0, 6, null);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = 1.0f;
                    Unit unit = Unit.INSTANCE;
                    troopClassifyLayout.addView(troopCreateClassifyOutItemView2, layoutParams);
                }
            }
        }
        if (QLog.isDebugVersion()) {
            QLog.d("TroopClassifyOutConfig", 4, "[configTroopClassify] curConfigVersion:" + curConfigVersion + ", size:" + curConfigClassifyList.size() + ", childCount:" + troopClassifyLayout.getChildCount());
        }
        int size3 = curConfigClassifyList.size();
        for (int i17 = 0; i17 < size3; i17++) {
            View childAt = troopClassifyLayout.getChildAt(i17);
            if (childAt instanceof TroopCreateClassifyOutItemView) {
                troopCreateClassifyOutItemView = (TroopCreateClassifyOutItemView) childAt;
            } else {
                troopCreateClassifyOutItemView = null;
            }
            if (troopCreateClassifyOutItemView != null) {
                if (i17 < curConfigClassifyList.size()) {
                    a aVar = curConfigClassifyList.get(i17);
                    Intrinsics.checkNotNullExpressionValue(aVar, "curConfigClassifyList[i]");
                    troopCreateClassifyOutItemView.d(aVar);
                    troopClassifyLayout.setVisibility(0);
                } else {
                    troopCreateClassifyOutItemView.h();
                }
            }
        }
    }

    private final void b() {
        boolean z16;
        String str = "102735";
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102735", false)) {
            curConfigClassifyList.clear();
            QLog.i("TroopClassifyOutConfig", 1, "[loadConfig] not open");
            return;
        }
        if (((ITroopCreatePage) QRoute.api(ITroopCreatePage.class)).getExperimentResultAndReport()) {
            str = "102957";
        }
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(str, new byte[0]);
        if (loadRawConfig.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            curConfigClassifyList.clear();
            QLog.i("TroopClassifyOutConfig", 1, "[loadConfig] no data");
            return;
        }
        int configVersion = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).getConfigVersion(str);
        QLog.i("TroopClassifyOutConfig", 1, "[loadConfig] version:" + configVersion + ", curVersion:" + curConfigVersion + ", size:" + curConfigClassifyList.size());
        Integer num = curConfigVersion;
        if (num == null || num.intValue() != configVersion) {
            curConfigClassifyList.clear();
            curConfigVersion = Integer.valueOf(configVersion);
            try {
                ArrayList<a> arrayList = new ArrayList<>();
                JSONArray jSONArray = new JSONObject(new String(loadRawConfig, Charsets.UTF_8)).getJSONArray("items");
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    String string = jSONObject.getString("name");
                    Intrinsics.checkNotNullExpressionValue(string, "obj.getString(\"name\")");
                    String string2 = jSONObject.getString("reportedID");
                    Intrinsics.checkNotNullExpressionValue(string2, "obj.getString(\"reportedID\")");
                    String string3 = jSONObject.getString("iconUrl");
                    Intrinsics.checkNotNullExpressionValue(string3, "obj.getString(\"iconUrl\")");
                    String string4 = jSONObject.getString(WadlProxyConsts.KEY_JUMP_URL);
                    Intrinsics.checkNotNullExpressionValue(string4, "obj.getString(\"jumpUrl\")");
                    arrayList.add(new a(string, string2, string3, string4));
                }
                arrayList.add(new a("\u66f4\u591a", "em_group_more_btn", "https://static-res.qq.com/static-res/qun/create/icons/quick_more.png", "em_group_more_btn"));
                curConfigClassifyList = arrayList;
            } catch (JSONException unused) {
                QLog.e("TroopClassifyOutConfig", 1, "[loadConfig] json parse exception");
            }
        }
    }
}
