package com.tencent.biz.pubaccount.aio;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/c;", "Lcom/tencent/mvi/api/ability/d;", "<init>", "()V", "a", "Lcom/tencent/biz/pubaccount/aio/c$a;", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public abstract class c implements com.tencent.mvi.api.ability.d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/c$a;", "Lcom/tencent/biz/pubaccount/aio/c;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/graphics/Bitmap;", "a", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "b", "(Landroid/graphics/Bitmap;)V", MimeHelper.IMAGE_SUBTYPE_BITMAP, "<init>", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.pubaccount.aio.c$a, reason: from toString */
    /* loaded from: classes4.dex */
    public static final /* data */ class GetInputBitmap extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Bitmap bitmap;

        public GetInputBitmap() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final void b(@Nullable Bitmap bitmap) {
            this.bitmap = bitmap;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GetInputBitmap) && Intrinsics.areEqual(this.bitmap, ((GetInputBitmap) other).bitmap)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Bitmap bitmap = this.bitmap;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.hashCode();
        }

        @NotNull
        public String toString() {
            return "GetInputBitmap(bitmap=" + this.bitmap + ')';
        }

        public GetInputBitmap(@Nullable Bitmap bitmap) {
            super(null);
            this.bitmap = bitmap;
        }

        public /* synthetic */ GetInputBitmap(Bitmap bitmap, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : bitmap);
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    c() {
    }
}
