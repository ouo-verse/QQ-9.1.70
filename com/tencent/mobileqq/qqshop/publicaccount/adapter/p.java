package com.tencent.mobileqq.qqshop.publicaccount.adapter;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\bX\u0010YB\u0019\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u0019\u0012\u0006\u0010&\u001a\u00020 \u00a2\u0006\u0004\bX\u0010ZJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0017\u0010\fR$\u0010\u001f\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\t\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010&\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\"\u0010,\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010(\u001a\u0004\b\u001a\u0010)\"\u0004\b*\u0010+R\"\u00101\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\n\u001a\u0004\b.\u0010\f\"\u0004\b/\u00100R\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b2\u0010\f\"\u0004\b3\u00100R\"\u0010:\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010=\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u00105\u001a\u0004\b;\u00107\"\u0004\b<\u00109R$\u0010D\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\b-\u0010A\"\u0004\bB\u0010CR\"\u0010G\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u00105\u001a\u0004\bE\u00107\"\u0004\bF\u00109R\"\u0010M\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR?\u0010V\u001a\u001f\u0012\u0013\u0012\u00110'\u00a2\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020Q\u0018\u00010N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010R\u001a\u0004\b\u0011\u0010S\"\u0004\bT\u0010UR\u0011\u0010W\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b?\u00107\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/p;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "id", "b", "e", "imageUrl", "c", "f", "landingUrl", "k", "title", TuxUIConstants.POP_BTN_TEXT, "i", TtmlNode.ATTR_TTS_ORIGIN, "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "g", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "()Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "setAdInfo", "(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V", "adInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", tl.h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "setMsgRecord", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "msgRecord", "", "J", "()J", "setMsgId", "(J)V", "msgId", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setVideoUrl", "(Ljava/lang/String;)V", AppConstants.Key.KEY_QZONE_VIDEO_URL, "l", "setVideoReportUrl", "videoReportUrl", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Z", "setVideoMsg", "(Z)V", "isVideoMsg", "p", "setVerticalAd", "isVerticalAd", "", DomainData.DOMAIN_NAME, "Ljava/lang/Float;", "()Ljava/lang/Float;", "setRatio", "(Ljava/lang/Float;)V", "ratio", "o", "setReportClick", "isReportClick", "I", "getActionType", "()I", "setActionType", "(I)V", "actionType", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "r", "(Lkotlin/jvm/functions/Function1;)V", "deleteListener", "isAdCardModel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String imageUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String landingUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String btnText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String origin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private qq_ad_get.QQAdGetRsp.AdInfo adInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgRecord msgRecord;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long msgId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String videoUrl;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String videoReportUrl;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isVideoMsg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isVerticalAd;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Float ratio;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean isReportClick;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int actionType;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Long, Unit> deleteListener;

    public p(@NotNull String id5, @NotNull String imageUrl, @NotNull String landingUrl, @NotNull String title, @NotNull String btnText, @NotNull String origin) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(landingUrl, "landingUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(btnText, "btnText");
        Intrinsics.checkNotNullParameter(origin, "origin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, id5, imageUrl, landingUrl, title, btnText, origin);
            return;
        }
        this.id = id5;
        this.imageUrl = imageUrl;
        this.landingUrl = landingUrl;
        this.title = title;
        this.btnText = btnText;
        this.origin = origin;
        this.videoUrl = "";
        this.videoReportUrl = "";
    }

    @Nullable
    public final qq_ad_get.QQAdGetRsp.AdInfo a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (qq_ad_get.QQAdGetRsp.AdInfo) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.adInfo;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.btnText;
    }

    @Nullable
    public final Function1<Long, Unit> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Function1) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.deleteListener;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.id;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.imageUrl;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof p)) {
            return false;
        }
        p pVar = (p) other;
        if (Intrinsics.areEqual(this.id, pVar.id) && Intrinsics.areEqual(this.imageUrl, pVar.imageUrl) && Intrinsics.areEqual(this.landingUrl, pVar.landingUrl) && Intrinsics.areEqual(this.title, pVar.title) && Intrinsics.areEqual(this.btnText, pVar.btnText) && Intrinsics.areEqual(this.origin, pVar.origin)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.landingUrl;
    }

    public final long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.msgId;
    }

    @Nullable
    public final MsgRecord h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (MsgRecord) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.msgRecord;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this)).intValue();
        }
        return (((((((((this.id.hashCode() * 31) + this.imageUrl.hashCode()) * 31) + this.landingUrl.hashCode()) * 31) + this.title.hashCode()) * 31) + this.btnText.hashCode()) * 31) + this.origin.hashCode();
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.origin;
    }

    @Nullable
    public final Float j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Float) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.ratio;
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.title;
    }

    @NotNull
    public final String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.videoReportUrl;
    }

    @NotNull
    public final String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.videoUrl;
    }

    public final boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        if (this.adInfo != null && this.actionType < 100) {
            return true;
        }
        return false;
    }

    public final boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return this.isReportClick;
    }

    public final boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return this.isVerticalAd;
    }

    public final boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.isVideoMsg;
    }

    public final void r(@Nullable Function1<? super Long, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) function1);
        } else {
            this.deleteListener = function1;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return "HeadCardModel(id=" + this.id + ", imageUrl=" + this.imageUrl + ", landingUrl=" + this.landingUrl + ", title=" + this.title + ", btnText=" + this.btnText + ", origin=" + this.origin + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public p(@NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo, @NotNull MsgRecord msgRecord) {
        this(r2, r3, r4, r5, r6, r8.o(msgRecord));
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        com.tencent.mobileqq.ecshop.view.adcard.model.a aVar = com.tencent.mobileqq.ecshop.view.adcard.model.a.f203961a;
        String a16 = aVar.a(adInfo);
        String c16 = aVar.c(adInfo);
        String d16 = aVar.d(adInfo);
        String f16 = aVar.f(adInfo);
        String b16 = aVar.b(adInfo);
        com.tencent.mobileqq.qqshop.message.d dVar = com.tencent.mobileqq.qqshop.message.d.f274478a;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) adInfo, (Object) msgRecord);
            return;
        }
        this.adInfo = adInfo;
        this.msgRecord = msgRecord;
        this.msgId = msgRecord.msgId;
        this.videoUrl = aVar.h(adInfo);
        this.videoReportUrl = aVar.g(adInfo);
        this.isVideoMsg = aVar.j(adInfo);
        this.isVerticalAd = aVar.i(adInfo);
        this.ratio = aVar.e(adInfo);
        this.isReportClick = dVar.x(msgRecord);
        this.actionType = dVar.d(msgRecord);
    }
}
