package a82;

import android.view.View;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionModel;
import com.tencent.mobileqq.matchfriend.utils.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bJ>\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u000e2\u0006\u0010\u0005\u001a\u00020\u0004JF\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u000eJ$\u0010\u0015\u001a\u00020\u000b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\u0006\u0010\u0014\u001a\u00020\u0004\u00a8\u0006\u0018"}, d2 = {"La82/a;", "", "Landroid/view/View;", "containerView", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "model", "", "position", "", "", "params", "", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "btn", "eleId", "event", "a", "data", "d", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f25717a = new a();

    a() {
    }

    public final void a(View btn, String eleId, String event, HashMap<String, Object> params) {
        Intrinsics.checkNotNullParameter(btn, "btn");
        Intrinsics.checkNotNullParameter(eleId, "eleId");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        d dVar = new d(btn.getContext());
        dVar.c("pg_bas_interactive_notification", new HashMap());
        ArrayList arrayList = new ArrayList();
        arrayList.add(eleId);
        dVar.b(arrayList);
        switch (event.hashCode()) {
            case -1321989219:
                if (event.equals("dt_imp")) {
                    dVar.g(eleId, params);
                    return;
                }
                return;
            case -952580819:
                if (event.equals("qq_imp")) {
                    dVar.m(eleId, "qq_imp", params);
                    return;
                }
                return;
            case 534585680:
                if (event.equals("qq_clck")) {
                    dVar.m(eleId, "qq_clck", params);
                    return;
                }
                return;
            case 1967827168:
                if (event.equals("dt_clck")) {
                    dVar.e(eleId, params);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void b(View containerView, HashMap<String, Object> params, QQStrangerLiteActionModel model) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(model, "model");
        d dVar = new d(containerView.getContext());
        dVar.c("pg_bas_interactive_notification", new HashMap());
        ArrayList arrayList = new ArrayList();
        arrayList.add("em_bas_nteractive_notification_message");
        dVar.b(arrayList);
        d(params, model);
        dVar.e("em_bas_nteractive_notification_message", params);
    }

    public final void c(View containerView, QQStrangerLiteActionModel model, int position, Map<String, Object> params) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(params, "params");
        d dVar = new d(containerView.getContext());
        dVar.c("pg_bas_interactive_notification", new HashMap());
        ArrayList arrayList = new ArrayList();
        arrayList.add("em_bas_nteractive_notification_message");
        dVar.b(arrayList);
        d(params, model);
        params.put("message_id", model.getMsgId());
        params.put("serial_number", Integer.valueOf(position));
        dVar.g("em_bas_nteractive_notification_message", params);
    }

    public final void d(Map<String, Object> params, QQStrangerLiteActionModel data) {
        int i3;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(data, "data");
        int sceneId = data.getSceneId();
        if (sceneId == 6) {
            i3 = 3;
        } else if (sceneId == 7) {
            i3 = 4;
        } else if (sceneId != 8) {
            i3 = data.getCanChat() ? 2 : 1;
        } else {
            i3 = 5;
        }
        params.put("interaction_type", Integer.valueOf(i3));
    }
}
