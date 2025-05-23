package com.tencent.mobileqq.aio.msg.template;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 \b2\u00020\u0001:\u0001\fBM\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\f\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014\"\u0004\b\u001e\u0010\u0016R$\u0010!\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b \u0010\u0016\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/template/b;", "", "Lorg/json/JSONObject;", PublicAccountMessageUtilImpl.META_NAME, "", "i", "", "jsonString", "g", "metaJson", h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setPrompt", "(Ljava/lang/String;)V", "prompt", "c", "setAddress", "address", "e", "setName", "name", "setLat", QCircleSchemeAttr.Polymerize.LAT, "setLon", "lon", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final MsgRecord msgRecord;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String prompt;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String address;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String name;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String lat;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String lon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/template/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.template.b$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48724);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@Nullable MsgRecord msgRecord, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgRecord, str, str2, str3, str4, str5);
            return;
        }
        this.msgRecord = msgRecord;
        this.prompt = str;
        this.address = str2;
        this.name = str3;
        this.lat = str4;
        this.lon = str5;
    }

    private final void i(JSONObject meta) {
        JSONObject optJSONObject = meta.optJSONObject("Location.Search");
        if (optJSONObject != null) {
            this.address = optJSONObject.optString("address");
            this.lon = optJSONObject.optString("lng");
            this.lat = optJSONObject.optString(QCircleSchemeAttr.Polymerize.LAT);
            this.name = optJSONObject.optString("name");
        }
    }

    @Nullable
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.address;
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.lat;
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.lon;
    }

    @Nullable
    public final MsgRecord d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MsgRecord) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msgRecord;
    }

    @Nullable
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.name;
    }

    @Nullable
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.prompt;
    }

    public final void g(@NotNull String jsonString) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) jsonString);
            return;
        }
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        try {
            JSONObject jSONObject = new JSONObject(jsonString);
            this.prompt = jSONObject.optString("prompt");
            JSONObject optJSONObject = jSONObject.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
            if (optJSONObject == null) {
                return;
            }
            i(optJSONObject);
        } catch (Exception e16) {
            QLog.e("PositionMsgInfo", 1, "exception when parse map share json: " + e16);
        }
    }

    public final void h(@NotNull String metaJson) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) metaJson);
            return;
        }
        Intrinsics.checkNotNullParameter(metaJson, "metaJson");
        try {
            i(new JSONObject(metaJson));
        } catch (Exception e16) {
            QLog.e("PositionMsgInfo", 1, "exception when parse meta json: " + e16);
        }
    }

    public /* synthetic */ b(MsgRecord msgRecord, String str, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(msgRecord, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? null : str4, (i3 & 32) != 0 ? null : str5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, msgRecord, str, str2, str3, str4, str5, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
