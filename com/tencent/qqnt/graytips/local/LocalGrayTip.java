package com.tencent.qqnt.graytips.local;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.graytips.action.f;
import com.tencent.qqnt.graytips.action.k;
import com.tencent.qqnt.graytips.action.u;
import com.tencent.qqnt.graytips.handler.b;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayMsgInfo;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002&\u0003BO\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\"\u001a\u00020\u001f\u0012\b\b\u0002\u0010#\u001a\u00020\u001f\u00a2\u0006\u0004\b$\u0010%R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u000e\u0010\u001dR\u0017\u0010\"\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b\u001b\u0010!R\u0017\u0010#\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010 \u001a\u0004\b\u0017\u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/qqnt/graytips/local/LocalGrayTip;", "", "", "a", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "peerUid", "", "b", "I", "()I", "chatType", "", "c", "J", "()J", "grayTipID", "Lorg/json/JSONObject;", "d", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "jsonObject", "e", h.F, "recentStr", "Lcom/tencent/qqnt/kernel/nativeinterface/JsonGrayMsgInfo;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/JsonGrayMsgInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/JsonGrayMsgInfo;", "jsonGrayMsgInfo", "", "Z", "()Z", "needStore", "needRecentContact", "<init>", "(Ljava/lang/String;IJLorg/json/JSONObject;Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/JsonGrayMsgInfo;ZZ)V", "LocalGrayTipBuilder", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class LocalGrayTip {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int chatType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long grayTipID;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JSONObject jsonObject;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String recentStr;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final JsonGrayMsgInfo jsonGrayMsgInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean needStore;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean needRecentContact;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/graytips/local/LocalGrayTip$a;", "", "Lorg/json/JSONObject;", "jsonObject", "b", "Lcom/tencent/qqnt/graytips/local/LocalGrayTip;", "a", "", "Ljava/lang/String;", "peerUid", "", "I", "chatType", "", "c", "J", "grayTipID", "Lcom/tencent/qqnt/kernel/nativeinterface/JsonGrayMsgInfo;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/JsonGrayMsgInfo;", "jsonGrayMsgInfo", "", "e", "Z", "needStore", "f", "needRecentContact", "g", "Lorg/json/JSONObject;", "mJsonObject", "<init>", "(Ljava/lang/String;IJLcom/tencent/qqnt/kernel/nativeinterface/JsonGrayMsgInfo;ZZ)V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String peerUid;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int chatType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final long grayTipID;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final JsonGrayMsgInfo jsonGrayMsgInfo;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean needStore;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean needRecentContact;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private JSONObject mJsonObject;

        public a(@NotNull String peerUid, int i3, long j3, @Nullable JsonGrayMsgInfo jsonGrayMsgInfo, boolean z16, boolean z17) {
            Intrinsics.checkNotNullParameter(peerUid, "peerUid");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, peerUid, Integer.valueOf(i3), Long.valueOf(j3), jsonGrayMsgInfo, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            this.peerUid = peerUid;
            this.chatType = i3;
            this.grayTipID = j3;
            this.jsonGrayMsgInfo = jsonGrayMsgInfo;
            this.needStore = z16;
            this.needRecentContact = z17;
            this.mJsonObject = new JSONObject();
        }

        @NotNull
        public final LocalGrayTip a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (LocalGrayTip) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return new LocalGrayTip(this.peerUid, this.chatType, this.grayTipID, this.mJsonObject, "", this.jsonGrayMsgInfo, this.needStore, this.needRecentContact, null);
        }

        @NotNull
        public final a b(@NotNull JSONObject jsonObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jsonObject);
            }
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            this.mJsonObject = jsonObject;
            return this;
        }
    }

    public /* synthetic */ LocalGrayTip(String str, int i3, long j3, JSONObject jSONObject, String str2, JsonGrayMsgInfo jsonGrayMsgInfo, boolean z16, boolean z17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, j3, jSONObject, str2, jsonGrayMsgInfo, z16, z17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, this, str, Integer.valueOf(i3), Long.valueOf(j3), jSONObject, str2, jsonGrayMsgInfo, Boolean.valueOf(z16), Boolean.valueOf(z17), defaultConstructorMarker);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.chatType;
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.grayTipID;
    }

    @Nullable
    public final JsonGrayMsgInfo c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (JsonGrayMsgInfo) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.jsonGrayMsgInfo;
    }

    @NotNull
    public final JSONObject d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (JSONObject) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.jsonObject;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.needRecentContact;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.needStore;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.peerUid;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.recentStr;
    }

    LocalGrayTip(String str, int i3, long j3, JSONObject jSONObject, String str2, JsonGrayMsgInfo jsonGrayMsgInfo, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Long.valueOf(j3), jSONObject, str2, jsonGrayMsgInfo, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.peerUid = str;
        this.chatType = i3;
        this.grayTipID = j3;
        this.jsonObject = jSONObject;
        this.recentStr = str2;
        this.jsonGrayMsgInfo = jsonGrayMsgInfo;
        this.needStore = z16;
        this.needRecentContact = z17;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u001f\u001a\u00020\f\u0012\u0006\u0010\"\u001a\u00020\b\u0012\u0006\u0010%\u001a\u00020#\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010)\u001a\u00020'\u0012\b\b\u0002\u0010+\u001a\u00020'\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\b8\u00109J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\bJ \u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\bJ \u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\bJ \u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bJ$\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0015\u001a\u00020\fJ*\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\u001cR\u0014\u0010\u001f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u0014\u0010\"\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010$R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010!R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010(R\u0014\u0010+\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u00100\u001a\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006:"}, d2 = {"Lcom/tencent/qqnt/graytips/local/LocalGrayTip$LocalGrayTipBuilder;", "", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/qqnt/graytips/action/f;", "actionInfo", "", "p", "", "color", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, LayoutAttrDefine.Gravity.Gravity, "", "o", "text", "g", "url", "a", "e", h.F, "src", QCircleSchemeAttr.Polymerize.ALT, "c", "uid", "nick", "uin", "clickColor", "k", "Lcom/tencent/qqnt/graytips/local/LocalGrayTip;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "peerUid", "b", "I", "chatType", "", "J", "grayTipID", "d", "", "Z", "needStore", "f", "needRecentContact", "Lcom/tencent/qqnt/kernel/nativeinterface/JsonGrayMsgInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/JsonGrayMsgInfo;", "jsonGrayMsgInfo", "Lorg/json/JSONArray;", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Lorg/json/JSONArray;", "itemArray", "Ljava/lang/StringBuilder;", "i", "Ljava/lang/StringBuilder;", "recentStr", "<init>", "(Ljava/lang/String;IJIZZLcom/tencent/qqnt/kernel/nativeinterface/JsonGrayMsgInfo;)V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class LocalGrayTipBuilder {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String peerUid;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int chatType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final long grayTipID;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int gravity;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean needStore;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean needRecentContact;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private JsonGrayMsgInfo jsonGrayMsgInfo;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy itemArray;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final StringBuilder recentStr;

        public LocalGrayTipBuilder(@NotNull String peerUid, int i3, long j3, int i16, boolean z16, boolean z17, @Nullable JsonGrayMsgInfo jsonGrayMsgInfo) {
            Lazy lazy;
            Intrinsics.checkNotNullParameter(peerUid, "peerUid");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, peerUid, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17), jsonGrayMsgInfo);
                return;
            }
            this.peerUid = peerUid;
            this.chatType = i3;
            this.grayTipID = j3;
            this.gravity = i16;
            this.needStore = z16;
            this.needRecentContact = z17;
            this.jsonGrayMsgInfo = jsonGrayMsgInfo;
            lazy = LazyKt__LazyJVMKt.lazy(LocalGrayTip$LocalGrayTipBuilder$itemArray$2.INSTANCE);
            this.itemArray = lazy;
            this.recentStr = new StringBuilder();
        }

        public static /* synthetic */ LocalGrayTipBuilder b(LocalGrayTipBuilder localGrayTipBuilder, String str, String str2, int i3, int i16, Object obj) {
            if ((i16 & 4) != 0) {
                i3 = 3;
            }
            return localGrayTipBuilder.a(str, str2, i3);
        }

        public static /* synthetic */ LocalGrayTipBuilder d(LocalGrayTipBuilder localGrayTipBuilder, String str, f fVar, String str2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                fVar = null;
            }
            if ((i3 & 4) != 0) {
                str2 = "";
            }
            return localGrayTipBuilder.c(str, fVar, str2);
        }

        public static /* synthetic */ LocalGrayTipBuilder f(LocalGrayTipBuilder localGrayTipBuilder, String str, String str2, int i3, int i16, Object obj) {
            if ((i16 & 4) != 0) {
                i3 = 3;
            }
            return localGrayTipBuilder.e(str, str2, i3);
        }

        public static /* synthetic */ LocalGrayTipBuilder i(LocalGrayTipBuilder localGrayTipBuilder, String str, int i3, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                i3 = 1;
            }
            return localGrayTipBuilder.g(str, i3);
        }

        public static /* synthetic */ LocalGrayTipBuilder j(LocalGrayTipBuilder localGrayTipBuilder, String str, f fVar, int i3, int i16, Object obj) {
            if ((i16 & 4) != 0) {
                i3 = 3;
            }
            return localGrayTipBuilder.h(str, fVar, i3);
        }

        public static /* synthetic */ LocalGrayTipBuilder l(LocalGrayTipBuilder localGrayTipBuilder, String str, String str2, String str3, int i3, int i16, Object obj) {
            if ((i16 & 4) != 0) {
                str3 = "";
            }
            if ((i16 & 8) != 0) {
                i3 = 3;
            }
            return localGrayTipBuilder.k(str, str2, str3, i3);
        }

        private final JSONArray n() {
            return (JSONArray) this.itemArray.getValue();
        }

        private final String o(int gravity) {
            if (gravity == 1) {
                return "center";
            }
            if (gravity != 2) {
                if (gravity != 3) {
                    if (gravity != 4) {
                        if (gravity != 5) {
                            return "center";
                        }
                        return "right";
                    }
                    return "left";
                }
                return "bottom";
            }
            return "top";
        }

        private final void p(JSONObject jsonObject, f actionInfo) {
            b a16 = com.tencent.qqnt.graytips.b.a(actionInfo.getActionType());
            if (a16 != null) {
                jsonObject.put("local_jp", actionInfo.getActionType());
                jsonObject.put("param", a16.b(actionInfo));
            }
        }

        private final LocalGrayTipBuilder q(JSONObject jsonObject, int color) {
            String str;
            if (color != 2) {
                if (color != 3) {
                    if (color != 4) {
                        str = "1";
                    } else {
                        str = "4";
                    }
                } else {
                    str = "3";
                }
            } else {
                str = "2";
            }
            jsonObject.put("col", str);
            return this;
        }

        @NotNull
        public final LocalGrayTipBuilder a(@NotNull String text, @NotNull String url, int color) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (LocalGrayTipBuilder) iPatchRedirector.redirect((short) 4, this, text, url, Integer.valueOf(color));
            }
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(url, "url");
            if (TextUtils.isEmpty(text)) {
                return this;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "url");
            jSONObject.put(FileReaderHelper.TXT_EXT, text);
            q(jSONObject, color);
            p(jSONObject, new u(url));
            n().mo162put(jSONObject);
            this.recentStr.append(text);
            return this;
        }

        @NotNull
        public final LocalGrayTipBuilder c(@NotNull String src, @Nullable f actionInfo, @NotNull String alt) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (LocalGrayTipBuilder) iPatchRedirector.redirect((short) 7, this, src, actionInfo, alt);
            }
            Intrinsics.checkNotNullParameter(src, "src");
            Intrinsics.checkNotNullParameter(alt, "alt");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "img");
            jSONObject.put("src", src);
            if (!TextUtils.isEmpty(alt)) {
                jSONObject.put(QCircleSchemeAttr.Polymerize.ALT, alt);
            }
            if (actionInfo != null) {
                p(jSONObject, actionInfo);
            }
            n().mo162put(jSONObject);
            this.recentStr.append(alt);
            return this;
        }

        @NotNull
        public final LocalGrayTipBuilder e(@NotNull String text, @NotNull String url, int color) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (LocalGrayTipBuilder) iPatchRedirector.redirect((short) 5, this, text, url, Integer.valueOf(color));
            }
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(url, "url");
            if (TextUtils.isEmpty(text)) {
                return this;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "url");
            jSONObject.put(FileReaderHelper.TXT_EXT, text);
            q(jSONObject, color);
            p(jSONObject, new k(url));
            n().mo162put(jSONObject);
            this.recentStr.append(text);
            return this;
        }

        @NotNull
        public final LocalGrayTipBuilder g(@NotNull String text, int color) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (LocalGrayTipBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) text, color);
            }
            Intrinsics.checkNotNullParameter(text, "text");
            if (TextUtils.isEmpty(text)) {
                return this;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "nor");
            jSONObject.put(FileReaderHelper.TXT_EXT, text);
            q(jSONObject, color);
            n().mo162put(jSONObject);
            this.recentStr.append(text);
            return this;
        }

        @NotNull
        public final LocalGrayTipBuilder h(@NotNull String text, @NotNull f actionInfo, int color) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (LocalGrayTipBuilder) iPatchRedirector.redirect((short) 6, this, text, actionInfo, Integer.valueOf(color));
            }
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
            if (TextUtils.isEmpty(text)) {
                return this;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "url");
            jSONObject.put(FileReaderHelper.TXT_EXT, text);
            q(jSONObject, color);
            p(jSONObject, actionInfo);
            n().mo162put(jSONObject);
            this.recentStr.append(text);
            return this;
        }

        @NotNull
        public final LocalGrayTipBuilder k(@NotNull String uid, @NotNull String nick, @NotNull String uin, int clickColor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (LocalGrayTipBuilder) iPatchRedirector.redirect((short) 8, this, uid, nick, uin, Integer.valueOf(clickColor));
            }
            Intrinsics.checkNotNullParameter(uid, "uid");
            Intrinsics.checkNotNullParameter(nick, "nick");
            Intrinsics.checkNotNullParameter(uin, "uin");
            if (TextUtils.isEmpty(nick)) {
                return this;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "qq");
            jSONObject.put("nm", nick);
            jSONObject.put("uid", uid);
            jSONObject.put("uin", uin);
            q(jSONObject, clickColor);
            n().mo162put(jSONObject);
            this.recentStr.append(nick);
            return this;
        }

        @NotNull
        public final LocalGrayTip m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (LocalGrayTip) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            if (n().length() != 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("align", o(this.gravity));
                jSONObject.put("items", n());
                String str = this.peerUid;
                int i3 = this.chatType;
                long j3 = this.grayTipID;
                String sb5 = this.recentStr.toString();
                Intrinsics.checkNotNullExpressionValue(sb5, "recentStr.toString()");
                return new LocalGrayTip(str, i3, j3, jSONObject, sb5, this.jsonGrayMsgInfo, this.needStore, this.needRecentContact, null);
            }
            throw new IllegalArgumentException("gray tip text must not be empty");
        }

        public /* synthetic */ LocalGrayTipBuilder(String str, int i3, long j3, int i16, boolean z16, boolean z17, JsonGrayMsgInfo jsonGrayMsgInfo, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, j3, (i17 & 8) != 0 ? 1 : i16, (i17 & 16) != 0 ? true : z16, (i17 & 32) != 0 ? true : z17, (i17 & 64) != 0 ? null : jsonGrayMsgInfo);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17), jsonGrayMsgInfo, Integer.valueOf(i17), defaultConstructorMarker);
        }
    }
}
