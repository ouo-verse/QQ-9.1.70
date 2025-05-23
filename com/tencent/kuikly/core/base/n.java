package com.tencent.kuikly.core.base;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u0000 \u00172\u00020\u0001:\u0001\bB'\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/kuikly/core/base/n;", "", "", "toString", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "getTop", "()F", "top", "b", "getLeft", "left", "c", "bottom", "d", "getRight", "right", "<init>", "(FFFF)V", "e", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class n {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final n f117196f = new n(0.0f, 0.0f, 0.0f, 0.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float top;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float left;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float bottom;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float right;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0006\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/base/n$a;", "", "", HippyControllerProps.STRING, "Lcom/tencent/kuikly/core/base/n;", "a", "default", "Lcom/tencent/kuikly/core/base/n;", "b", "()Lcom/tencent/kuikly/core/base/n;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.base.n$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final n a(String string) {
            List split$default;
            Intrinsics.checkNotNullParameter(string, "string");
            if (!(string.length() == 0)) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) string, new String[]{" "}, false, 0, 6, (Object) null);
                if (split$default.size() >= 4) {
                    return new n(Float.parseFloat((String) split$default.get(0)), Float.parseFloat((String) split$default.get(1)), Float.parseFloat((String) split$default.get(2)), Float.parseFloat((String) split$default.get(3)));
                }
                return b();
            }
            return b();
        }

        public final n b() {
            return n.f117196f;
        }

        Companion() {
        }
    }

    public n(float f16, float f17, float f18, float f19) {
        this.top = f16;
        this.left = f17;
        this.bottom = f18;
        this.right = f19;
    }

    /* renamed from: b, reason: from getter */
    public final float getBottom() {
        return this.bottom;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.top);
        sb5.append(TokenParser.SP);
        sb5.append(this.left);
        sb5.append(TokenParser.SP);
        sb5.append(this.bottom);
        sb5.append(TokenParser.SP);
        sb5.append(this.right);
        return sb5.toString();
    }

    public boolean equals(Object other) {
        if (other != null && (other instanceof n)) {
            n nVar = (n) other;
            if (this.top == nVar.top) {
                if (this.left == nVar.left) {
                    if (this.bottom == nVar.bottom) {
                        if (this.right == nVar.right) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
