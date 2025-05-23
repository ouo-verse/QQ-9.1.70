package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewholder;

import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewholder.QFSPublicAccountStaggeredItemViewFactory;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/viewholder/QFSPublicAccountFollowUsersItemViewFactory;", "", "", "c", "b", "Lkotlin/Lazy;", "()I", "baseType", "<init>", "()V", "ItemType", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountFollowUsersItemViewFactory {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSPublicAccountFollowUsersItemViewFactory f87121a = new QFSPublicAccountFollowUsersItemViewFactory();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy baseType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/viewholder/QFSPublicAccountFollowUsersItemViewFactory$ItemType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "FOLLOW_USERS_ITEM_TYPE", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public enum ItemType {
        FOLLOW_USERS_ITEM_TYPE(QFSPublicAccountFollowUsersItemViewFactory.f87121a.b() + 1);

        private final int type;

        ItemType(int i3) {
            this.type = i3;
        }

        public final int getType() {
            return this.type;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewholder.QFSPublicAccountFollowUsersItemViewFactory$baseType$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r4v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                int lastIndex;
                Integer num;
                QFSPublicAccountStaggeredItemViewFactory.ItemType[] values = QFSPublicAccountStaggeredItemViewFactory.ItemType.values();
                if (values.length == 0) {
                    num = null;
                } else {
                    Integer valueOf = Integer.valueOf(values[0].getType());
                    lastIndex = ArraysKt___ArraysKt.getLastIndex(values);
                    ?? it = new IntRange(1, lastIndex).iterator();
                    while (it.hasNext()) {
                        Integer valueOf2 = Integer.valueOf(values[it.nextInt()].getType());
                        if (valueOf.compareTo(valueOf2) < 0) {
                            valueOf = valueOf2;
                        }
                    }
                    num = valueOf;
                }
                Integer num2 = num;
                Integer valueOf3 = Integer.valueOf(num2 != null ? num2.intValue() : 0);
                QLog.d("QFSPublicAccountFollowUsersItemViewFactory", 1, "baseType:" + valueOf3.intValue());
                return valueOf3;
            }
        });
        baseType = lazy;
    }

    QFSPublicAccountFollowUsersItemViewFactory() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int b() {
        return ((Number) baseType.getValue()).intValue();
    }

    public final int c() {
        return ItemType.values().length;
    }
}
