package com.tencent.qqnt.msg.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.EmojiAD;
import com.tencent.qqnt.kernel.nativeinterface.EmojiMall;
import com.tencent.qqnt.kernel.nativeinterface.EmojiZPlan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u00102\u001a\u00020\u0004\u00a2\u0006\u0004\b3\u00104J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010#\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R$\u0010*\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\n\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\"\u00102\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010.\u001a\u0004\b\t\u0010/\"\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/msg/data/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setEmojiFrom", "(Ljava/lang/Integer;)V", "emojiFrom", "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setEmojiWebUrl", "(Ljava/lang/String;)V", "emojiWebUrl", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiAD;", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiAD;", "()Lcom/tencent/qqnt/kernel/nativeinterface/EmojiAD;", "setEmojiAd", "(Lcom/tencent/qqnt/kernel/nativeinterface/EmojiAD;)V", "emojiAd", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiMall;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiMall;", "()Lcom/tencent/qqnt/kernel/nativeinterface/EmojiMall;", tl.h.F, "(Lcom/tencent/qqnt/kernel/nativeinterface/EmojiMall;)V", "emojiMall", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiZPlan;", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiZPlan;", "f", "()Lcom/tencent/qqnt/kernel/nativeinterface/EmojiZPlan;", "i", "(Lcom/tencent/qqnt/kernel/nativeinterface/EmojiZPlan;)V", "emojiZPlan", "g", "j", "picSubSubType", "I", "()I", "setEmojiAITemplateID", "(I)V", "emojiAITemplateID", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/EmojiAD;Lcom/tencent/qqnt/kernel/nativeinterface/EmojiMall;Lcom/tencent/qqnt/kernel/nativeinterface/EmojiZPlan;Ljava/lang/Integer;I)V", "msg_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer emojiFrom;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String emojiWebUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EmojiAD emojiAd;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EmojiMall emojiMall;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EmojiZPlan emojiZPlan;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer picSubSubType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int emojiAITemplateID;

    public g() {
        this(null, null, null, null, null, null, 0, 127, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            return;
        }
        iPatchRedirector.redirect((short) 28, (Object) this);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.emojiAITemplateID;
    }

    @Nullable
    public final EmojiAD b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (EmojiAD) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.emojiAd;
    }

    @Nullable
    public final Integer c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Integer) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.emojiFrom;
    }

    @Nullable
    public final EmojiMall d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (EmojiMall) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.emojiMall;
    }

    @Nullable
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.emojiWebUrl;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        if (Intrinsics.areEqual(this.emojiFrom, gVar.emojiFrom) && Intrinsics.areEqual(this.emojiWebUrl, gVar.emojiWebUrl) && Intrinsics.areEqual(this.emojiAd, gVar.emojiAd) && Intrinsics.areEqual(this.emojiMall, gVar.emojiMall) && Intrinsics.areEqual(this.emojiZPlan, gVar.emojiZPlan) && Intrinsics.areEqual(this.picSubSubType, gVar.picSubSubType) && this.emojiAITemplateID == gVar.emojiAITemplateID) {
            return true;
        }
        return false;
    }

    @Nullable
    public final EmojiZPlan f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (EmojiZPlan) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.emojiZPlan;
    }

    @Nullable
    public final Integer g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Integer) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.picSubSubType;
    }

    public final void h(@Nullable EmojiMall emojiMall) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) emojiMall);
        } else {
            this.emojiMall = emojiMall;
        }
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        Integer num = this.emojiFrom;
        int i3 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i16 = hashCode * 31;
        String str = this.emojiWebUrl;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        EmojiAD emojiAD = this.emojiAd;
        if (emojiAD == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = emojiAD.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        EmojiMall emojiMall = this.emojiMall;
        if (emojiMall == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = emojiMall.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        EmojiZPlan emojiZPlan = this.emojiZPlan;
        if (emojiZPlan == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = emojiZPlan.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        Integer num2 = this.picSubSubType;
        if (num2 != null) {
            i3 = num2.hashCode();
        }
        return ((i26 + i3) * 31) + this.emojiAITemplateID;
    }

    public final void i(@Nullable EmojiZPlan emojiZPlan) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) emojiZPlan);
        } else {
            this.emojiZPlan = emojiZPlan;
        }
    }

    public final void j(@Nullable Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) num);
        } else {
            this.picSubSubType = num;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return "PicExtBizInfo(emojiFrom=" + this.emojiFrom + ", emojiWebUrl=" + this.emojiWebUrl + ", emojiAd=" + this.emojiAd + ", emojiMall=" + this.emojiMall + ", emojiZPlan=" + this.emojiZPlan + ", picSubSubType=" + this.picSubSubType + ", emojiAITemplateID=" + this.emojiAITemplateID + ")";
    }

    public g(@Nullable Integer num, @Nullable String str, @Nullable EmojiAD emojiAD, @Nullable EmojiMall emojiMall, @Nullable EmojiZPlan emojiZPlan, @Nullable Integer num2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, num, str, emojiAD, emojiMall, emojiZPlan, num2, Integer.valueOf(i3));
            return;
        }
        this.emojiFrom = num;
        this.emojiWebUrl = str;
        this.emojiAd = emojiAD;
        this.emojiMall = emojiMall;
        this.emojiZPlan = emojiZPlan;
        this.picSubSubType = num2;
        this.emojiAITemplateID = i3;
    }

    public /* synthetic */ g(Integer num, String str, EmojiAD emojiAD, EmojiMall emojiMall, EmojiZPlan emojiZPlan, Integer num2, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : num, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? null : emojiAD, (i16 & 8) != 0 ? null : emojiMall, (i16 & 16) != 0 ? null : emojiZPlan, (i16 & 32) != 0 ? null : num2, (i16 & 64) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, num, str, emojiAD, emojiMall, emojiZPlan, num2, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
