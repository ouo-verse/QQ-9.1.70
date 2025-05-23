package com.tencent.mobileqq.notification.modularize;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0016\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0016\u0010\u0019\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\nR\u0016\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\n\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/notification/modularize/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "actionText", "b", "actionJump", "c", "bgUrl", "d", "voiceUrl", "e", "content", "f", "title", "", "g", "J", "duration", tl.h.F, "Z", "isLoop", "i", "leftIcon", "j", "bgTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String actionText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String actionJump;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String bgUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String voiceUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String content;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String title;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long duration;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public boolean isLoop;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String leftIcon;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String bgTitle;

    public b() {
        this(null, null, null, null, null, null, 0L, false, null, null, 1023, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return;
        }
        iPatchRedirector.redirect((short) 17, (Object) this);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.actionText, bVar.actionText) && Intrinsics.areEqual(this.actionJump, bVar.actionJump) && Intrinsics.areEqual(this.bgUrl, bVar.bgUrl) && Intrinsics.areEqual(this.voiceUrl, bVar.voiceUrl) && Intrinsics.areEqual(this.content, bVar.content) && Intrinsics.areEqual(this.title, bVar.title) && this.duration == bVar.duration && this.isLoop == bVar.isLoop && Intrinsics.areEqual(this.leftIcon, bVar.leftIcon) && Intrinsics.areEqual(this.bgTitle, bVar.bgTitle)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        int hashCode = ((((((((((((this.actionText.hashCode() * 31) + this.actionJump.hashCode()) * 31) + this.bgUrl.hashCode()) * 31) + this.voiceUrl.hashCode()) * 31) + this.content.hashCode()) * 31) + this.title.hashCode()) * 31) + androidx.fragment.app.a.a(this.duration)) * 31;
        boolean z16 = this.isLoop;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((hashCode + i3) * 31) + this.leftIcon.hashCode()) * 31) + this.bgTitle.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "ForcePushInfo(actionText=" + this.actionText + ", actionJump=" + this.actionJump + ", bgUrl=" + this.bgUrl + ", voiceUrl=" + this.voiceUrl + ", content=" + this.content + ", title=" + this.title + ", duration=" + this.duration + ", isLoop=" + this.isLoop + ", leftIcon=" + this.leftIcon + ", bgTitle=" + this.bgTitle + ")";
    }

    public b(@NotNull String actionText, @NotNull String actionJump, @NotNull String bgUrl, @NotNull String voiceUrl, @NotNull String content, @NotNull String title, long j3, boolean z16, @NotNull String leftIcon, @NotNull String bgTitle) {
        Intrinsics.checkNotNullParameter(actionText, "actionText");
        Intrinsics.checkNotNullParameter(actionJump, "actionJump");
        Intrinsics.checkNotNullParameter(bgUrl, "bgUrl");
        Intrinsics.checkNotNullParameter(voiceUrl, "voiceUrl");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(leftIcon, "leftIcon");
        Intrinsics.checkNotNullParameter(bgTitle, "bgTitle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, actionText, actionJump, bgUrl, voiceUrl, content, title, Long.valueOf(j3), Boolean.valueOf(z16), leftIcon, bgTitle);
            return;
        }
        this.actionText = actionText;
        this.actionJump = actionJump;
        this.bgUrl = bgUrl;
        this.voiceUrl = voiceUrl;
        this.content = content;
        this.title = title;
        this.duration = j3;
        this.isLoop = z16;
        this.leftIcon = leftIcon;
        this.bgTitle = bgTitle;
    }

    public /* synthetic */ b(String str, String str2, String str3, String str4, String str5, String str6, long j3, boolean z16, String str7, String str8, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? 0L : j3, (i3 & 128) != 0 ? false : z16, (i3 & 256) != 0 ? "" : str7, (i3 & 512) != 0 ? "" : str8);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5, str6, Long.valueOf(j3), Boolean.valueOf(z16), str7, str8, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
