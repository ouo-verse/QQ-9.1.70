package com.tencent.sqshow.zootopia.avatar;

import android.content.Context;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.sqshow.zootopia.avatar.event.StretchAvatarEvent;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/f;", "Lcom/tencent/sqshow/zootopia/avatar/e;", "Landroid/content/Context;", "context", "", "c", "", "targetState", "withAnim", "", "a", "Le84/b;", "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final f f369932a = new f();

    f() {
    }

    @Override // com.tencent.sqshow.zootopia.avatar.e
    public void a(int targetState, boolean withAnim) {
        SimpleEventBus.getInstance().dispatchEvent(new StretchAvatarEvent(targetState, withAnim));
    }

    public e84.b b() {
        return e84.a.f395879a;
    }

    public boolean c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        b bVar = (b) CommonExKt.p(context, ZplanCacheComponentType.AVATAR_COMPONENT_VIEW);
        return bVar != null && bVar.getState() == 2;
    }
}
