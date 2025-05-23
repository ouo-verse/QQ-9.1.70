package com.tencent.mobileqq.matchfriend.reborn.publish.anim;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J<\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ\"\u0010\u0015\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/d;", "", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/n;", "controller", "", "b", "d", "", "bizId", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/p;", "endTextViewInfo", "endPicViewInfo", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/c;", "extraTextInfo", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/b;", "extraPicInfo", "a", "Landroid/view/View;", "startTextView", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/m;", "picInfo", "c", "", "Ljava/util/Map;", "controllerMap", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f245261a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, n> controllerMap = new LinkedHashMap();

    d() {
    }

    public final void a(String bizId, ViewInfo endTextViewInfo, ViewInfo endPicViewInfo, ExtraTextInfo extraTextInfo, ExtraPicInfo extraPicInfo) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(extraTextInfo, "extraTextInfo");
        Intrinsics.checkNotNullParameter(extraPicInfo, "extraPicInfo");
        QLog.d("FeedPublishAnimHelper", 2, "initEndParams");
        n nVar = controllerMap.get(bizId);
        if (nVar != null) {
            nVar.U1(endTextViewInfo, endPicViewInfo, extraPicInfo, extraTextInfo);
        }
    }

    public final void b(n controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        String bizId = controller.getBizId();
        Map<String, n> map = controllerMap;
        if (map.containsKey(bizId)) {
            return;
        }
        map.put(bizId, controller);
    }

    public final void c(String bizId, View startTextView, PicInfo picInfo) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        n nVar = controllerMap.get(bizId);
        if (nVar != null) {
            nVar.o0(startTextView, picInfo != null ? picInfo.getStartImageView() : null);
            nVar.M5(startTextView, picInfo);
        }
    }

    public final void d(n controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        controllerMap.remove(controller.getBizId());
    }
}
