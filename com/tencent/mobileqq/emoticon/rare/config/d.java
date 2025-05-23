package com.tencent.mobileqq.emoticon.rare.config;

import com.tencent.ark.ark;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \u00032\u00020\u0001:\u0001\u0006B'\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0007\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\r\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/emoticon/rare/config/d;", "", "", "e", "", "toString", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "id", "b", "d", "tailText", "c", "relatedChainId", "relatedResultId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tailText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String relatedChainId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String relatedResultId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/emoticon/rare/config/d$a;", "", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "Lcom/tencent/mobileqq/emoticon/rare/config/d;", "a", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.emoticon.rare.config.d$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final d a(@NotNull JSONObject json) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) json);
            }
            Intrinsics.checkNotNullParameter(json, "json");
            String str = "";
            String optString = json.optString("emojiId", "");
            if (optString == null) {
                optString = "";
            }
            String optString2 = json.optString("msgTailText");
            if (optString2 == null) {
                optString2 = "";
            }
            String optString3 = json.optString("relatedChainEmojiId");
            if (optString3 == null) {
                optString3 = "";
            }
            String optString4 = json.optString("relatedResultId", "");
            if (optString4 != null) {
                str = optString4;
            }
            return new d(optString, optString2, optString3, str);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33086);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull String id5, @NotNull String tailText, @NotNull String relatedChainId, @NotNull String relatedResultId) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(tailText, "tailText");
        Intrinsics.checkNotNullParameter(relatedChainId, "relatedChainId");
        Intrinsics.checkNotNullParameter(relatedResultId, "relatedResultId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, id5, tailText, relatedChainId, relatedResultId);
            return;
        }
        this.id = id5;
        this.tailText = tailText;
        this.relatedChainId = relatedChainId;
        this.relatedResultId = relatedResultId;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.id;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.relatedChainId;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.relatedResultId;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.tailText;
    }

    public final boolean e() {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.id.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (this.tailText.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (this.relatedChainId.length() > 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    return true;
                }
            }
        }
        return false;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "{ id:" + this.id + " chainId:" + this.relatedChainId + " resultId:" + this.relatedResultId + " }";
    }
}
