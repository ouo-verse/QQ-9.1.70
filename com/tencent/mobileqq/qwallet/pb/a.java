package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.shadow.core.runtime.skin.loader.SkinResFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0003\b\t\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002\u0082\u0001\u0002\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pb/a;", "", "other", "", "c", "<init>", "()V", "d", "a", "b", "Lcom/tencent/mobileqq/qwallet/pb/a$b;", "Lcom/tencent/mobileqq/qwallet/pb/a$c;", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class a implements Comparable<a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002J\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pb/a$a;", "", "", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$Promotion;", "promotions", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", IQWalletPreferenceApi.KEY_SKIN_LIST, "Lcom/tencent/mobileqq/qwallet/pb/a;", "a", "c", SkinResFactory.SKIN_THEME_APK_SAVE_DIR, "b", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pb.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<a> a(@NotNull List<RedPackSkin$Promotion> promotions, @NotNull List<RedPackSkin$RecommendSkin> skinList) {
            int collectionSizeOrDefault;
            int collectionSizeOrDefault2;
            List<a> plus;
            Intrinsics.checkNotNullParameter(promotions, "promotions");
            Intrinsics.checkNotNullParameter(skinList, "skinList");
            List<RedPackSkin$Promotion> list = promotions;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Promotion((RedPackSkin$Promotion) it.next()));
            }
            List<RedPackSkin$RecommendSkin> list2 = skinList;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it5 = list2.iterator();
            while (it5.hasNext()) {
                arrayList2.add(new Skin((RedPackSkin$RecommendSkin) it5.next()));
            }
            plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
            return plus;
        }

        @NotNull
        public final a b(@NotNull RedPackSkin$RecommendSkin skin) {
            Intrinsics.checkNotNullParameter(skin, "skin");
            return new Skin(skin);
        }

        @NotNull
        public final List<a> c(@NotNull List<RedPackSkin$RecommendSkin> skinList) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(skinList, "skinList");
            List<RedPackSkin$RecommendSkin> list = skinList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Skin((RedPackSkin$RecommendSkin) it.next()));
            }
            return arrayList;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pb/a$b;", "Lcom/tencent/mobileqq/qwallet/pb/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$Promotion;", "e", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$Promotion;", h.F, "()Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$Promotion;", "value", "<init>", "(Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$Promotion;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pb.a$b, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class Promotion extends a {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RedPackSkin$Promotion value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Promotion(@NotNull RedPackSkin$Promotion value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof Promotion) && Intrinsics.areEqual(this.value, ((Promotion) other).value)) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final RedPackSkin$Promotion getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "Promotion(value=" + this.value + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pb/a$c;", "Lcom/tencent/mobileqq/qwallet/pb/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", "e", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", h.F, "()Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", "value", "<init>", "(Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pb.a$c, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class Skin extends a {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RedPackSkin$RecommendSkin value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Skin(@NotNull RedPackSkin$RecommendSkin value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof Skin) && Intrinsics.areEqual(this.value, ((Skin) other).value)) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final RedPackSkin$RecommendSkin getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "Skin(value=" + this.value + ')';
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull a other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this instanceof Promotion) {
            return -1;
        }
        if (!(other instanceof Promotion)) {
            if ((this instanceof Skin) && (other instanceof Skin)) {
                if (!((Skin) this).getValue().has_got.get()) {
                    if (((Skin) other).getValue().has_got.get()) {
                        return -1;
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    a() {
    }
}
