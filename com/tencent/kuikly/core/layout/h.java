package com.tencent.kuikly.core.layout;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\b\u0012\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/kuikly/core/layout/h;", "", "Lcom/tencent/kuikly/core/layout/d;", "i", "", "a", UserInfo.SEX_FEMALE, "c", "()F", "g", "(F)V", HippyTKDListViewAdapter.X, "b", "d", tl.h.F, "y", "f", "width", "e", "height", "<init>", "(FFFF)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float x;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float y;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float width;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float height;

    public h(float f16, float f17, float f18, float f19) {
        this.x = f16;
        this.y = f17;
        this.width = f18;
        this.height = f19;
    }

    /* renamed from: a, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    /* renamed from: b, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    /* renamed from: c, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: d, reason: from getter */
    public final float getY() {
        return this.y;
    }

    public final void e(float f16) {
        this.height = f16;
    }

    public final void f(float f16) {
        this.width = f16;
    }

    public final void g(float f16) {
        this.x = f16;
    }

    public final void h(float f16) {
        this.y = f16;
    }

    public final d i() {
        return new d(this.x, this.y, this.width, this.height);
    }
}
