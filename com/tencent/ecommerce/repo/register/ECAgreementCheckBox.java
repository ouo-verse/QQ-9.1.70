package com.tencent.ecommerce.repo.register;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u000e\u0010\u001b\"\u0004\b\u0012\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/ecommerce/repo/register/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "text", "", "Lcom/tencent/ecommerce/repo/register/b;", "b", "Ljava/util/List;", "()Ljava/util/List;", "links", "c", "Z", "isRequired", "d", "checkByDefault", "e", "I", "type", "f", "()Z", "(Z)V", "isChecked", "<init>", "(Ljava/lang/String;Ljava/util/List;ZZIZ)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.register.a, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECAgreementCheckBox {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String text;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<ECAgreementLink> links;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isRequired;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean checkByDefault;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final int type;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isChecked;

    public ECAgreementCheckBox() {
        this(null, null, false, false, 0, false, 63, null);
    }

    public final List<ECAgreementLink> a() {
        return this.links;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    public final void c(boolean z16) {
        this.isChecked = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.text;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ECAgreementLink> list = this.links;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean z16 = this.isRequired;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        boolean z17 = this.checkByDefault;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int i18 = (((i16 + i17) * 31) + this.type) * 31;
        boolean z18 = this.isChecked;
        return i18 + (z18 ? 1 : z18 ? 1 : 0);
    }

    public String toString() {
        return "ECAgreementCheckBox(text=" + this.text + ", links=" + this.links + ", isRequired=" + this.isRequired + ", checkByDefault=" + this.checkByDefault + ", type=" + this.type + ", isChecked=" + this.isChecked + ")";
    }

    public ECAgreementCheckBox(String str, List<ECAgreementLink> list, boolean z16, boolean z17, int i3, boolean z18) {
        this.text = str;
        this.links = list;
        this.isRequired = z16;
        this.checkByDefault = z17;
        this.type = i3;
        this.isChecked = z18;
    }

    public /* synthetic */ ECAgreementCheckBox(String str, List list, boolean z16, boolean z17, int i3, boolean z18, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? new ArrayList() : list, (i16 & 4) != 0 ? false : z16, (i16 & 8) != 0 ? false : z17, (i16 & 16) != 0 ? 0 : i3, (i16 & 32) == 0 ? z18 : false);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECAgreementCheckBox)) {
            return false;
        }
        ECAgreementCheckBox eCAgreementCheckBox = (ECAgreementCheckBox) other;
        return Intrinsics.areEqual(this.text, eCAgreementCheckBox.text) && Intrinsics.areEqual(this.links, eCAgreementCheckBox.links) && this.isRequired == eCAgreementCheckBox.isRequired && this.checkByDefault == eCAgreementCheckBox.checkByDefault && this.type == eCAgreementCheckBox.type && this.isChecked == eCAgreementCheckBox.isChecked;
    }
}
