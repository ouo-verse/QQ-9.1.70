package com.tencent.biz.qui.quipolarlight;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/qui/quipolarlight/a;", "", "<init>", "()V", "a", "b", "Lcom/tencent/biz/qui/quipolarlight/a$a;", "Lcom/tencent/biz/qui/quipolarlight/a$b;", "QUIPolarLight_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public abstract class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/biz/qui/quipolarlight/a$a;", "Lcom/tencent/biz/qui/quipolarlight/a;", "<init>", "()V", "QUIPolarLight_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.biz.qui.quipolarlight.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0951a extends a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C0951a f95204a = new C0951a();

        C0951a() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\n\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/qui/quipolarlight/a$b;", "Lcom/tencent/biz/qui/quipolarlight/a;", "", "a", UserInfo.SEX_FEMALE, "d", "()F", "radius", "b", "centerX", "c", "centerY", "e", "startAlpha", "endAlpha", "<init>", "(FFFFF)V", "QUIPolarLight_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes5.dex */
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final float radius;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final float centerX;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final float centerY;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final float startAlpha;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final float endAlpha;

        public b(float f16, float f17, float f18, float f19, float f26) {
            super(null);
            this.radius = f16;
            this.centerX = f17;
            this.centerY = f18;
            this.startAlpha = f19;
            this.endAlpha = f26;
        }

        /* renamed from: a, reason: from getter */
        public final float getCenterX() {
            return this.centerX;
        }

        /* renamed from: b, reason: from getter */
        public final float getCenterY() {
            return this.centerY;
        }

        /* renamed from: c, reason: from getter */
        public final float getEndAlpha() {
            return this.endAlpha;
        }

        /* renamed from: d, reason: from getter */
        public final float getRadius() {
            return this.radius;
        }

        /* renamed from: e, reason: from getter */
        public final float getStartAlpha() {
            return this.startAlpha;
        }
    }

    a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
