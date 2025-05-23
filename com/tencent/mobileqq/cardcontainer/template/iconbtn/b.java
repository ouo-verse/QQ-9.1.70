package com.tencent.mobileqq.cardcontainer.template.iconbtn;

import com.tencent.mobileqq.cardcontainer.data.CardType;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00162\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/iconbtn/b;", "Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", "", "u", "Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "c", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "other", "", "b", "a", "Lcom/tencent/mobileqq/cardcontainer/template/iconbtn/a;", "l", "Lcom/tencent/mobileqq/cardcontainer/template/iconbtn/a;", "t", "()Lcom/tencent/mobileqq/cardcontainer/template/iconbtn/a;", "setBizModel", "(Lcom/tencent/mobileqq/cardcontainer/template/iconbtn/a;)V", "bizModel", "data", "<init>", "(Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b extends ContainerData {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a bizModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/iconbtn/b$a;", "", "", "BG_DARK_URL", "Ljava/lang/String;", "BG_LIGHT_URL", "BTN_SCHEME", "BTN_TEXT", "IMAGE_DARK_URL", "IMAGE_LIGHT_URL", "TAG", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.template.iconbtn.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41336);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull ContainerData data) {
        super(data);
        Intrinsics.checkNotNullParameter(data, "data");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) data);
        } else {
            u();
        }
    }

    private final void u() {
        Object firstOrNull;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        try {
            ArrayList<com.tencent.mobileqq.cardcontainer.data.b> h16 = h();
            if (h16 != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) h16);
                com.tencent.mobileqq.cardcontainer.data.b bVar = (com.tencent.mobileqq.cardcontainer.data.b) firstOrNull;
                if (bVar != null) {
                    String b16 = bVar.b();
                    if (b16 != null) {
                        JSONObject jSONObject = new JSONObject(b16);
                        String optString = jSONObject.optString("imageLightUrl", "");
                        String optString2 = jSONObject.optString("imageDarkUrl", "");
                        String optString3 = jSONObject.optString("bgLightUrl", "");
                        String optString4 = jSONObject.optString("bgDarkUrl", "");
                        String optString5 = jSONObject.optString(TuxUIConstants.POP_BTN_TEXT, "");
                        str6 = jSONObject.optString("btnScheme", "");
                        str4 = optString4;
                        str5 = optString5;
                        str2 = optString2;
                        str3 = optString3;
                        str = optString;
                    } else {
                        str = null;
                        str2 = null;
                        str3 = null;
                        str4 = null;
                        str5 = null;
                        str6 = null;
                    }
                    this.bizModel = new a(bVar.c(), str, str2, str3, str4, bVar.g(), bVar.f(), str5, str6, bVar.e());
                }
            }
        } catch (Exception e16) {
            QLog.e("CardContainer.IconBtnCardData", 1, "parseItemExtraInfo exception: " + e16);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.data.ContainerData, com.tencent.mobileqq.cardcontainer.data.a
    public boolean a(@NotNull com.tencent.mobileqq.cardcontainer.data.a other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) other)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(other, "other");
        if (!(other instanceof b)) {
            return false;
        }
        return Intrinsics.areEqual(this.bizModel, ((b) other).bizModel);
    }

    @Override // com.tencent.mobileqq.cardcontainer.data.ContainerData, com.tencent.mobileqq.cardcontainer.data.a
    public boolean b(@NotNull com.tencent.mobileqq.cardcontainer.data.a other) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) other)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(other, "other");
        if (!(other instanceof b)) {
            return false;
        }
        a aVar = this.bizModel;
        String str2 = null;
        if (aVar != null) {
            str = aVar.h();
        } else {
            str = null;
        }
        a aVar2 = ((b) other).bizModel;
        if (aVar2 != null) {
            str2 = aVar2.h();
        }
        return Intrinsics.areEqual(str, str2);
    }

    @Override // com.tencent.mobileqq.cardcontainer.data.ContainerData, com.tencent.mobileqq.cardcontainer.data.a
    @NotNull
    public CardType c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CardType) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return CardType.IconPlusOneBtn;
    }

    @Nullable
    public final a t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.bizModel;
    }
}
