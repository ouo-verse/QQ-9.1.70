package com.tencent.mobileqq.qqecommerce.biz.kuikly.preload;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/RequestType;", "", "", "type", "I", "getType", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "TYPE_SSO", "TYPE_HTTP", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public enum RequestType {
    TYPE_SSO(0),
    TYPE_HTTP(1);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/RequestType$a;", "", "", "type", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/RequestType;", "a", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.preload.RequestType$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RequestType a(int type) {
            RequestType requestType;
            RequestType[] values = RequestType.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    requestType = null;
                    break;
                }
                requestType = values[i3];
                if (requestType.getType() == type) {
                    break;
                }
                i3++;
            }
            return requestType == null ? RequestType.TYPE_SSO : requestType;
        }

        Companion() {
        }
    }

    RequestType(int i3) {
        this.type = i3;
    }

    public final int getType() {
        return this.type;
    }
}
