package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001\tBA\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u000e\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\t\u0010\u0015R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troop/api/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getSelfIntroduceTitle", "()Ljava/lang/String;", "selfIntroduceTitle", "b", "getSelfIntroduceHint", "selfIntroduceHint", "c", "selfIntroduceWording", "d", "I", "()I", "selfIntroduceWordingMaxCount", "e", "addTroopOptionNeedVerifyWordingMaxCount", "f", "addTroopOptionNeedAnswerQuestionWordingMaxCount", "g", "getNickNameHolder", "nickNameHolder", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;)V", h.F, "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class g {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String selfIntroduceTitle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String selfIntroduceHint;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String selfIntroduceWording;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int selfIntroduceWordingMaxCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int addTroopOptionNeedVerifyWordingMaxCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int addTroopOptionNeedAnswerQuestionWordingMaxCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String nickNameHolder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/api/g$a;", "", "", "DEFAULT_INTRODUCTION_WORDING", "Ljava/lang/String;", "NICK_NAME_HOLDER", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.api.g$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23245);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g(@NotNull String selfIntroduceTitle, @NotNull String selfIntroduceHint, @NotNull String selfIntroduceWording, int i3, int i16, int i17, @NotNull String nickNameHolder) {
        Intrinsics.checkNotNullParameter(selfIntroduceTitle, "selfIntroduceTitle");
        Intrinsics.checkNotNullParameter(selfIntroduceHint, "selfIntroduceHint");
        Intrinsics.checkNotNullParameter(selfIntroduceWording, "selfIntroduceWording");
        Intrinsics.checkNotNullParameter(nickNameHolder, "nickNameHolder");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, selfIntroduceTitle, selfIntroduceHint, selfIntroduceWording, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), nickNameHolder);
            return;
        }
        this.selfIntroduceTitle = selfIntroduceTitle;
        this.selfIntroduceHint = selfIntroduceHint;
        this.selfIntroduceWording = selfIntroduceWording;
        this.selfIntroduceWordingMaxCount = i3;
        this.addTroopOptionNeedVerifyWordingMaxCount = i16;
        this.addTroopOptionNeedAnswerQuestionWordingMaxCount = i17;
        this.nickNameHolder = nickNameHolder;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.addTroopOptionNeedAnswerQuestionWordingMaxCount;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.addTroopOptionNeedVerifyWordingMaxCount;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.selfIntroduceWording;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.selfIntroduceWordingMaxCount;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        if (Intrinsics.areEqual(this.selfIntroduceTitle, gVar.selfIntroduceTitle) && Intrinsics.areEqual(this.selfIntroduceHint, gVar.selfIntroduceHint) && Intrinsics.areEqual(this.selfIntroduceWording, gVar.selfIntroduceWording) && this.selfIntroduceWordingMaxCount == gVar.selfIntroduceWordingMaxCount && this.addTroopOptionNeedVerifyWordingMaxCount == gVar.addTroopOptionNeedVerifyWordingMaxCount && this.addTroopOptionNeedAnswerQuestionWordingMaxCount == gVar.addTroopOptionNeedAnswerQuestionWordingMaxCount && Intrinsics.areEqual(this.nickNameHolder, gVar.nickNameHolder)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return (((((((((((this.selfIntroduceTitle.hashCode() * 31) + this.selfIntroduceHint.hashCode()) * 31) + this.selfIntroduceWording.hashCode()) * 31) + this.selfIntroduceWordingMaxCount) * 31) + this.addTroopOptionNeedVerifyWordingMaxCount) * 31) + this.addTroopOptionNeedAnswerQuestionWordingMaxCount) * 31) + this.nickNameHolder.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "TroopVerifySwitch(selfIntroduceTitle=" + this.selfIntroduceTitle + ", selfIntroduceHint=" + this.selfIntroduceHint + ", selfIntroduceWording=" + this.selfIntroduceWording + ", selfIntroduceWordingMaxCount=" + this.selfIntroduceWordingMaxCount + ", addTroopOptionNeedVerifyWordingMaxCount=" + this.addTroopOptionNeedVerifyWordingMaxCount + ", addTroopOptionNeedAnswerQuestionWordingMaxCount=" + this.addTroopOptionNeedAnswerQuestionWordingMaxCount + ", nickNameHolder=" + this.nickNameHolder + ")";
    }

    public /* synthetic */ g(String str, String str2, String str3, int i3, int i16, int i17, String str4, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i3, i16, i17, (i18 & 64) != 0 ? "#{nickname}" : str4);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str4, Integer.valueOf(i18), defaultConstructorMarker);
    }
}
