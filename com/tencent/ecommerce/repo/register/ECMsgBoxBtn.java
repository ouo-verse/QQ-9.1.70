package com.tencent.ecommerce.repo.register;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0006H\u00c6\u0003J1\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/repo/register/ECMsgBoxBtn;", "Ljava/io/Serializable;", "text", "", "url", "shouldPopPage", "", "shouldKeepMsgBox", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getShouldKeepMsgBox", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class ECMsgBoxBtn implements Serializable {
    private final boolean shouldKeepMsgBox;
    public final boolean shouldPopPage;
    public final String text;
    public final String url;

    public ECMsgBoxBtn(String str, String str2, boolean z16, boolean z17) {
        this.text = str;
        this.url = str2;
        this.shouldPopPage = z16;
        this.shouldKeepMsgBox = z17;
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getShouldPopPage() {
        return this.shouldPopPage;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getShouldKeepMsgBox() {
        return this.shouldKeepMsgBox;
    }

    public final ECMsgBoxBtn copy(String text, String url, boolean shouldPopPage, boolean shouldKeepMsgBox) {
        return new ECMsgBoxBtn(text, url, shouldPopPage, shouldKeepMsgBox);
    }

    public final boolean getShouldKeepMsgBox() {
        return this.shouldKeepMsgBox;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.text;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z16 = this.shouldPopPage;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        boolean z17 = this.shouldKeepMsgBox;
        return i16 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public String toString() {
        return "ECMsgBoxBtn(text=" + this.text + ", url=" + this.url + ", shouldPopPage=" + this.shouldPopPage + ", shouldKeepMsgBox=" + this.shouldKeepMsgBox + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECMsgBoxBtn)) {
            return false;
        }
        ECMsgBoxBtn eCMsgBoxBtn = (ECMsgBoxBtn) other;
        return Intrinsics.areEqual(this.text, eCMsgBoxBtn.text) && Intrinsics.areEqual(this.url, eCMsgBoxBtn.url) && this.shouldPopPage == eCMsgBoxBtn.shouldPopPage && this.shouldKeepMsgBox == eCMsgBoxBtn.shouldKeepMsgBox;
    }

    public static /* synthetic */ ECMsgBoxBtn copy$default(ECMsgBoxBtn eCMsgBoxBtn, String str, String str2, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = eCMsgBoxBtn.text;
        }
        if ((i3 & 2) != 0) {
            str2 = eCMsgBoxBtn.url;
        }
        if ((i3 & 4) != 0) {
            z16 = eCMsgBoxBtn.shouldPopPage;
        }
        if ((i3 & 8) != 0) {
            z17 = eCMsgBoxBtn.shouldKeepMsgBox;
        }
        return eCMsgBoxBtn.copy(str, str2, z16, z17);
    }
}
