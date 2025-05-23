package com.tencent.state.template.data;

import as4.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010%B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b$\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0002H\u00c6\u0003J;\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0014\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018\u00a8\u0006)"}, d2 = {"Lcom/tencent/state/template/data/FloatingLeveTip;", "", "", "component1", "component2", "component3", "", "component4", "component5", "btnOk", "btnCancel", "tip", "scene", "detail", "copy", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getBtnOk", "()Ljava/lang/String;", "setBtnOk", "(Ljava/lang/String;)V", "getBtnCancel", "setBtnCancel", "getTip", "setTip", "I", "getScene", "()I", "setScene", "(I)V", "getDetail", "setDetail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "Las4/c;", "pb", "(Las4/c;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class FloatingLeveTip {
    private String btnCancel;
    private String btnOk;
    private String detail;
    private int scene;
    private String tip;

    public FloatingLeveTip(String btnOk, String btnCancel, String tip, int i3, String detail) {
        Intrinsics.checkNotNullParameter(btnOk, "btnOk");
        Intrinsics.checkNotNullParameter(btnCancel, "btnCancel");
        Intrinsics.checkNotNullParameter(tip, "tip");
        Intrinsics.checkNotNullParameter(detail, "detail");
        this.btnOk = btnOk;
        this.btnCancel = btnCancel;
        this.tip = tip;
        this.scene = i3;
        this.detail = detail;
    }

    /* renamed from: component1, reason: from getter */
    public final String getBtnOk() {
        return this.btnOk;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBtnCancel() {
        return this.btnCancel;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTip() {
        return this.tip;
    }

    /* renamed from: component4, reason: from getter */
    public final int getScene() {
        return this.scene;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDetail() {
        return this.detail;
    }

    public final FloatingLeveTip copy(String btnOk, String btnCancel, String tip, int scene, String detail) {
        Intrinsics.checkNotNullParameter(btnOk, "btnOk");
        Intrinsics.checkNotNullParameter(btnCancel, "btnCancel");
        Intrinsics.checkNotNullParameter(tip, "tip");
        Intrinsics.checkNotNullParameter(detail, "detail");
        return new FloatingLeveTip(btnOk, btnCancel, tip, scene, detail);
    }

    public final String getBtnCancel() {
        return this.btnCancel;
    }

    public final String getBtnOk() {
        return this.btnOk;
    }

    public final String getDetail() {
        return this.detail;
    }

    public final int getScene() {
        return this.scene;
    }

    public final String getTip() {
        return this.tip;
    }

    public int hashCode() {
        String str = this.btnOk;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.btnCancel;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.tip;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.scene) * 31;
        String str4 = this.detail;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setBtnCancel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.btnCancel = str;
    }

    public final void setBtnOk(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.btnOk = str;
    }

    public final void setDetail(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.detail = str;
    }

    public final void setScene(int i3) {
        this.scene = i3;
    }

    public final void setTip(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tip = str;
    }

    public String toString() {
        return "FloatingLeveTip(btnOk=" + this.btnOk + ", btnCancel=" + this.btnCancel + ", tip=" + this.tip + ", scene=" + this.scene + ", detail=" + this.detail + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FloatingLeveTip(c pb5) {
        this(r2, r3, r4, r5, r6);
        Intrinsics.checkNotNullParameter(pb5, "pb");
        String str = pb5.f26883e;
        Intrinsics.checkNotNullExpressionValue(str, "pb.btnOk");
        String str2 = pb5.f26884f;
        Intrinsics.checkNotNullExpressionValue(str2, "pb.btnCancel");
        String str3 = pb5.f26880b;
        Intrinsics.checkNotNullExpressionValue(str3, "pb.tip");
        int i3 = pb5.f26879a;
        String str4 = pb5.f26882d;
        Intrinsics.checkNotNullExpressionValue(str4, "pb.deatil");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FloatingLeveTip)) {
            return false;
        }
        FloatingLeveTip floatingLeveTip = (FloatingLeveTip) other;
        return Intrinsics.areEqual(this.btnOk, floatingLeveTip.btnOk) && Intrinsics.areEqual(this.btnCancel, floatingLeveTip.btnCancel) && Intrinsics.areEqual(this.tip, floatingLeveTip.tip) && this.scene == floatingLeveTip.scene && Intrinsics.areEqual(this.detail, floatingLeveTip.detail);
    }

    public static /* synthetic */ FloatingLeveTip copy$default(FloatingLeveTip floatingLeveTip, String str, String str2, String str3, int i3, String str4, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = floatingLeveTip.btnOk;
        }
        if ((i16 & 2) != 0) {
            str2 = floatingLeveTip.btnCancel;
        }
        String str5 = str2;
        if ((i16 & 4) != 0) {
            str3 = floatingLeveTip.tip;
        }
        String str6 = str3;
        if ((i16 & 8) != 0) {
            i3 = floatingLeveTip.scene;
        }
        int i17 = i3;
        if ((i16 & 16) != 0) {
            str4 = floatingLeveTip.detail;
        }
        return floatingLeveTip.copy(str, str5, str6, i17, str4);
    }
}
