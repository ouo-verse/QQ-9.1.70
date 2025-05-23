package com.tencent.ecommerce.repo.aftersale.apply.item;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/item/ItemType;", "", "", "value", "I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "TYPE_UNKNOW", "TYPE_PRODUCT_ORDER", "TYPE_OPTION_ITEM", "TYPE_SUB_OPTION_ITEM", "TYPE_REFUND_AMOUNT", "TYPE_EXTRA_SUPPLEMENT", "TYPE_POST_METHOD", "TYPE_ENTRY_ITEM", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum ItemType {
    TYPE_UNKNOW(0),
    TYPE_PRODUCT_ORDER(1),
    TYPE_OPTION_ITEM(2),
    TYPE_SUB_OPTION_ITEM(3),
    TYPE_REFUND_AMOUNT(4),
    TYPE_EXTRA_SUPPLEMENT(5),
    TYPE_POST_METHOD(6),
    TYPE_ENTRY_ITEM(7);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/item/ItemType$a;", "", "", "value", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/ItemType;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.aftersale.apply.item.ItemType$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ItemType a(int value) {
            ItemType itemType;
            ItemType[] values = ItemType.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    itemType = null;
                    break;
                }
                itemType = values[i3];
                if (itemType.ordinal() == value) {
                    break;
                }
                i3++;
            }
            return itemType != null ? itemType : ItemType.TYPE_UNKNOW;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    ItemType(int i3) {
        this.value = i3;
    }
}
