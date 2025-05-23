package com.tencent.mobileqq.search.business.contact.entity;

import com.tencent.mobileqq.search.model.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0000J\t\u0010\n\u001a\u00020\tH\u00d6\u0001R\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/entity/c;", "", "other", "", "equals", "", "hashCode", "another", "b", "", "toString", "a", "Ljava/lang/String;", "getIndex", "()Ljava/lang/String;", "index", "Lcom/tencent/mobileqq/search/model/k;", "Lcom/tencent/mobileqq/search/model/k;", "()Lcom/tencent/mobileqq/search/model/k;", "model", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/search/model/k;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.business.contact.entity.c, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class ContactsSearchItemData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String index;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final k model;

    public ContactsSearchItemData(@NotNull String index, @Nullable k kVar) {
        Intrinsics.checkNotNullParameter(index, "index");
        this.index = index;
        this.model = kVar;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final k getModel() {
        return this.model;
    }

    public final boolean b(@NotNull ContactsSearchItemData another) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        CharSequence charSequence5;
        CharSequence charSequence6;
        String str;
        Intrinsics.checkNotNullParameter(another, "another");
        k kVar = this.model;
        String str2 = null;
        if (kVar != null) {
            charSequence = kVar.u();
        } else {
            charSequence = null;
        }
        k kVar2 = another.model;
        if (kVar2 != null) {
            charSequence2 = kVar2.u();
        } else {
            charSequence2 = null;
        }
        if (Intrinsics.areEqual(charSequence, charSequence2)) {
            k kVar3 = this.model;
            if (kVar3 != null) {
                charSequence3 = kVar3.t();
            } else {
                charSequence3 = null;
            }
            k kVar4 = another.model;
            if (kVar4 != null) {
                charSequence4 = kVar4.t();
            } else {
                charSequence4 = null;
            }
            if (Intrinsics.areEqual(charSequence3, charSequence4)) {
                k kVar5 = this.model;
                if (kVar5 != null) {
                    charSequence5 = kVar5.m();
                } else {
                    charSequence5 = null;
                }
                k kVar6 = another.model;
                if (kVar6 != null) {
                    charSequence6 = kVar6.m();
                } else {
                    charSequence6 = null;
                }
                if (Intrinsics.areEqual(charSequence5, charSequence6)) {
                    k kVar7 = this.model;
                    if (kVar7 != null) {
                        str = kVar7.l();
                    } else {
                        str = null;
                    }
                    k kVar8 = another.model;
                    if (kVar8 != null) {
                        str2 = kVar8.l();
                    }
                    if (Intrinsics.areEqual(str, str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContactsSearchItemData)) {
            return false;
        }
        return Intrinsics.areEqual(this.index, ((ContactsSearchItemData) other).index);
    }

    public int hashCode() {
        return this.index.hashCode();
    }

    @NotNull
    public String toString() {
        return "ContactsSearchItemData(index=" + this.index + ", model=" + this.model + ")";
    }
}
