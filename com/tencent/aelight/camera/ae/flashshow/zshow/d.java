package com.tencent.aelight.camera.ae.flashshow.zshow;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/zshow/d;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "deviceBlackListForPag", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class d {

    @SerializedName("device_black_list_for_pag")
    private final ArrayList<String> deviceBlackListForPag = new ArrayList<>();

    public final ArrayList<String> a() {
        return this.deviceBlackListForPag;
    }
}
