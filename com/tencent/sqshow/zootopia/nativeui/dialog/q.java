package com.tencent.sqshow.zootopia.nativeui.dialog;

import android.content.Context;
import b94.d;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u0014\u0010\u0011\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/dialog/q;", "", "", "Luv4/az;", "list", "c", "Lorg/json/JSONObject;", "jsonObject", "", "d", "e", "g", "f", "", "actionParams", "a", "originList", "b", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j channel;

    public q(Context context, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.context = context;
        this.channel = channel;
    }

    private final List<az> c(List<az> list) {
        ArrayList arrayList = new ArrayList();
        for (az azVar : list) {
            b94.d avatarDressController = this.channel.getAvatarDressController();
            if (!(avatarDressController != null ? avatarDressController.Kf(azVar) : false) && !r94.b.w(azVar, com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.l().b())) {
                arrayList.add(azVar);
            }
        }
        return arrayList;
    }

    private final void d(JSONObject jsonObject) {
        ga4.g a16;
        a16 = ga4.j.f401682a.a(2, this.channel, this.context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : false);
        a16.show();
    }

    private final void e(JSONObject jsonObject) {
        this.channel.c().setValue(new Pair<>(2, jsonObject));
    }

    private final void f(JSONObject jsonObject) {
        ga4.g a16;
        QLog.i("SchemeActionHandler", 1, "showMakeFaceDialog jsonObject:" + jsonObject);
        a16 = ga4.j.f401682a.a(16, this.channel, this.context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : false);
        a16.show();
    }

    private final void g(JSONObject jsonObject) {
        this.channel.c().setValue(new Pair<>(1, jsonObject));
    }

    public final void a(String actionParams) {
        Intrinsics.checkNotNullParameter(actionParams, "actionParams");
        if (actionParams.length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(actionParams);
            String optString = jSONObject.optString("action");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            QLog.d("SchemeActionHandler", 1, "action : " + optString + ", data : " + optJSONObject);
            if (optString != null) {
                switch (optString.hashCode()) {
                    case -1888742814:
                        if (!optString.equals("open_shopping_cart")) {
                            break;
                        } else {
                            d(optJSONObject);
                            break;
                        }
                    case -740830000:
                        if (!optString.equals("open_experience_card")) {
                            break;
                        } else {
                            e(optJSONObject);
                            break;
                        }
                    case 274068186:
                        if (!optString.equals("open_pick_color")) {
                            break;
                        } else {
                            g(optJSONObject);
                            break;
                        }
                    case 1049451097:
                        if (!optString.equals("open_make_face")) {
                            break;
                        } else {
                            f(optJSONObject);
                            break;
                        }
                }
            }
        } catch (Exception e16) {
            QLog.e("SchemeActionHandler", 1, "parse json error => " + e16);
        }
    }

    public final void b(List<az> originList) {
        Intrinsics.checkNotNullParameter(originList, "originList");
        List<az> c16 = c(originList);
        QLog.i("SchemeActionHandler", 1, "handleTryDressAction originList:" + originList.size() + ", list:" + c16.size());
        if (c16.isEmpty()) {
            return;
        }
        QLog.d("SchemeActionHandler", 1, "try dress action => " + c16);
        b94.d avatarDressController = this.channel.getAvatarDressController();
        if (avatarDressController != null) {
            d.a.d(avatarDressController, c16, null, null, null, 14, null);
        }
    }
}
