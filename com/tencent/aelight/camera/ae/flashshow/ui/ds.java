package com.tencent.aelight.camera.ae.flashshow.ui;

import com.tencent.ams.dsdk.core.DKConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0003\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/ds;", "", "", "a", "Z", "c", "()Z", "show", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "categoryName", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ds {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean show;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String materialId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String categoryName;

    public ds(boolean z16, String str, String str2) {
        this.show = z16;
        this.materialId = str;
        this.categoryName = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    /* renamed from: b, reason: from getter */
    public final String getMaterialId() {
        return this.materialId;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getShow() {
        return this.show;
    }

    public /* synthetic */ ds(boolean z16, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2);
    }
}
