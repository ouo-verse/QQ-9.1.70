package com.tencent.ecommerce.repo.register;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB3\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J?\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\t\u0010\u0010\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0018R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/repo/register/ECMsgBox;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "Lcom/tencent/ecommerce/repo/register/ECMsgBoxBtn;", "component4", "component5", "disPlay", "title", "text", "leftBtn", "rightBtn", "copy", "toString", "", "hashCode", "", "other", "equals", "Z", "Ljava/lang/String;", "Lcom/tencent/ecommerce/repo/register/ECMsgBoxBtn;", "getRightBtn", "()Lcom/tencent/ecommerce/repo/register/ECMsgBoxBtn;", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/repo/register/ECMsgBoxBtn;Lcom/tencent/ecommerce/repo/register/ECMsgBoxBtn;)V", "Companion", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class ECMsgBox implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final boolean disPlay;
    public final ECMsgBoxBtn leftBtn;
    private final ECMsgBoxBtn rightBtn;
    public final String text;
    public final String title;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/repo/register/ECMsgBox$a;", "", "Lorg/json/JSONObject;", "msgBoxData", "Lcom/tencent/ecommerce/repo/register/ECMsgBox;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.register.ECMsgBox$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ECMsgBox a(JSONObject msgBoxData) {
            JSONObject optJSONObject = msgBoxData.optJSONObject("left_btn");
            ECMsgBoxBtn eCMsgBoxBtn = optJSONObject != null ? new ECMsgBoxBtn(optJSONObject.optString("text", ""), optJSONObject.optString("url", ""), optJSONObject.optBoolean("should_pop_page", false), optJSONObject.optBoolean("should_keep_msg_box", false)) : null;
            JSONObject optJSONObject2 = msgBoxData.optJSONObject("right_btn");
            return new ECMsgBox(msgBoxData.optBoolean("display", false), msgBoxData.optString("title", ""), msgBoxData.optString("text", ""), eCMsgBoxBtn, optJSONObject2 != null ? new ECMsgBoxBtn(optJSONObject2.optString("text", ""), optJSONObject2.optString("url", ""), optJSONObject2.optBoolean("should_pop_page", false), optJSONObject2.optBoolean("should_keep_msg_box", false)) : null);
        }
    }

    public ECMsgBox(boolean z16, String str, String str2, ECMsgBoxBtn eCMsgBoxBtn, ECMsgBoxBtn eCMsgBoxBtn2) {
        this.disPlay = z16;
        this.title = str;
        this.text = str2;
        this.leftBtn = eCMsgBoxBtn;
        this.rightBtn = eCMsgBoxBtn2;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getDisPlay() {
        return this.disPlay;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component4, reason: from getter */
    public final ECMsgBoxBtn getLeftBtn() {
        return this.leftBtn;
    }

    /* renamed from: component5, reason: from getter */
    public final ECMsgBoxBtn getRightBtn() {
        return this.rightBtn;
    }

    public final ECMsgBox copy(boolean disPlay, String title, String text, ECMsgBoxBtn leftBtn, ECMsgBoxBtn rightBtn) {
        return new ECMsgBox(disPlay, title, text, leftBtn, rightBtn);
    }

    public final ECMsgBoxBtn getRightBtn() {
        return this.rightBtn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z16 = this.disPlay;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        String str = this.title;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.text;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ECMsgBoxBtn eCMsgBoxBtn = this.leftBtn;
        int hashCode3 = (hashCode2 + (eCMsgBoxBtn != null ? eCMsgBoxBtn.hashCode() : 0)) * 31;
        ECMsgBoxBtn eCMsgBoxBtn2 = this.rightBtn;
        return hashCode3 + (eCMsgBoxBtn2 != null ? eCMsgBoxBtn2.hashCode() : 0);
    }

    public String toString() {
        return "ECMsgBox(disPlay=" + this.disPlay + ", title=" + this.title + ", text=" + this.text + ", leftBtn=" + this.leftBtn + ", rightBtn=" + this.rightBtn + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECMsgBox)) {
            return false;
        }
        ECMsgBox eCMsgBox = (ECMsgBox) other;
        return this.disPlay == eCMsgBox.disPlay && Intrinsics.areEqual(this.title, eCMsgBox.title) && Intrinsics.areEqual(this.text, eCMsgBox.text) && Intrinsics.areEqual(this.leftBtn, eCMsgBox.leftBtn) && Intrinsics.areEqual(this.rightBtn, eCMsgBox.rightBtn);
    }

    public static /* synthetic */ ECMsgBox copy$default(ECMsgBox eCMsgBox, boolean z16, String str, String str2, ECMsgBoxBtn eCMsgBoxBtn, ECMsgBoxBtn eCMsgBoxBtn2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = eCMsgBox.disPlay;
        }
        if ((i3 & 2) != 0) {
            str = eCMsgBox.title;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            str2 = eCMsgBox.text;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            eCMsgBoxBtn = eCMsgBox.leftBtn;
        }
        ECMsgBoxBtn eCMsgBoxBtn3 = eCMsgBoxBtn;
        if ((i3 & 16) != 0) {
            eCMsgBoxBtn2 = eCMsgBox.rightBtn;
        }
        return eCMsgBox.copy(z16, str3, str4, eCMsgBoxBtn3, eCMsgBoxBtn2);
    }
}
