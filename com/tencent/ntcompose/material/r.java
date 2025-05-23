package com.tencent.ntcompose.material;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/ntcompose/material/r;", "", "a", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface r {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ntcompose/material/r$a;", "Lcom/tencent/ntcompose/material/r;", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "count", "<init>", "(I)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements r {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int count;

        public a(int i3) {
            this.count = i3;
            if (!(i3 > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }

        /* renamed from: a, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public boolean equals(Object other) {
            return (other instanceof a) && this.count == ((a) other).count;
        }

        public int hashCode() {
            return -this.count;
        }
    }
}
