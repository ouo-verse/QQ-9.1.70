package com.tencent.ecommerce.biz.live;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/live/LiveTabId;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "LIVE_TAB_NONE", "LIVE_TAB_PRODUCT", "LIVE_TAB_GOK", "LIVE_TAB_QSHOP", "LIVE_TAB_COUPON", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public enum LiveTabId {
    LIVE_TAB_NONE(-1),
    LIVE_TAB_PRODUCT(0),
    LIVE_TAB_GOK(1),
    LIVE_TAB_QSHOP(2),
    LIVE_TAB_COUPON(3);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/live/LiveTabId$a;", "", "", "value", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "a", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.live.LiveTabId$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final LiveTabId a(int value) {
            LiveTabId liveTabId;
            boolean z16;
            LiveTabId[] values = LiveTabId.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    liveTabId = values[i3];
                    if (liveTabId.getValue() == value) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i3++;
                } else {
                    liveTabId = null;
                    break;
                }
            }
            if (liveTabId == null) {
                return LiveTabId.LIVE_TAB_PRODUCT;
            }
            return liveTabId;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    LiveTabId(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}
