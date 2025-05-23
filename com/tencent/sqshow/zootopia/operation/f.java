package com.tencent.sqshow.zootopia.operation;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002R\u001a\u0010\r\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/f;", "", "", "silver", "gold", "", "c", "b", "a", "", "Ljava/lang/String;", "getPORTAL_STORE_SILVER_AREA", "()Ljava/lang/String;", "PORTAL_STORE_SILVER_AREA", "I", "currentSilver", "d", "currentGold", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f372119a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String PORTAL_STORE_SILVER_AREA = "mqqapi://zplan/enterAvatarScene?src_type=app&version=1.0&referer=3002&sceneType=1&sceneData={\"ViewType\":1,\"SubScene\":{\"SceneType\":6,\"SceneParams\":{\"active_id\":\"rectab:2\"}}}";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int currentSilver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int currentGold;

    f() {
    }

    public final int a() {
        return currentGold;
    }

    public final int b() {
        return currentSilver;
    }

    public final void c(int silver, int gold) {
        currentSilver = silver;
        currentGold = gold;
    }
}
