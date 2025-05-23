package com.tencent.mobileqq.cardcontainer.template.imagenobutton;

import com.tencent.mobileqq.cardcontainer.data.CardType;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/imagenobutton/b;", "Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", "", "u", "Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "c", "Lcom/tencent/mobileqq/cardcontainer/template/imagenobutton/a;", "l", "Lcom/tencent/mobileqq/cardcontainer/template/imagenobutton/a;", "t", "()Lcom/tencent/mobileqq/cardcontainer/template/imagenobutton/a;", "setBizModel", "(Lcom/tencent/mobileqq/cardcontainer/template/imagenobutton/a;)V", "bizModel", "containerData", "<init>", "(Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/imagenobutton/b$a;", "", "", "TAG", "Ljava/lang/String;", "", "TYPE_IMAGE", "I", "TYPE_TEXT", "TYPE_VIDEO", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.template.imagenobutton.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41419);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull ContainerData containerData) {
        super(containerData);
        Intrinsics.checkNotNullParameter(containerData, "containerData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) containerData);
        } else {
            u();
        }
    }

    private final void u() {
        Object firstOrNull;
        boolean z16;
        String str;
        int i3;
        String str2;
        String str3;
        try {
            ArrayList<com.tencent.mobileqq.cardcontainer.data.b> h16 = h();
            if (h16 != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) h16);
                com.tencent.mobileqq.cardcontainer.data.b bVar = (com.tencent.mobileqq.cardcontainer.data.b) firstOrNull;
                if (bVar != null) {
                    String b16 = bVar.b();
                    if (b16 != null && b16.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        i3 = 0;
                        str = "";
                        str3 = str;
                        str2 = str3;
                    } else {
                        JSONObject jSONObject = new JSONObject(b16);
                        int optInt = jSONObject.optInt("type", 0);
                        String optString = jSONObject.optString("avatar", "");
                        Intrinsics.checkNotNullExpressionValue(optString, "extJson.optString(\"avatar\", \"\")");
                        String optString2 = jSONObject.optString("bizIconUrl", "");
                        Intrinsics.checkNotNullExpressionValue(optString2, "extJson.optString(\"bizIconUrl\", \"\")");
                        String optString3 = jSONObject.optString("bizData", "");
                        Intrinsics.checkNotNullExpressionValue(optString3, "extJson.optString(\"bizData\", \"\")");
                        str = optString;
                        i3 = optInt;
                        str2 = optString3;
                        str3 = optString2;
                    }
                    try {
                        this.bizModel = new a(bVar.c(), i3, str, bVar.g(), bVar.f(), bVar.a(), bVar.e(), str3, str2);
                    } catch (Exception e16) {
                        e = e16;
                        QLog.e("CardContainer.ImageNoButtonCardData", 1, "parseContainerData " + e);
                    }
                }
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.data.ContainerData, com.tencent.mobileqq.cardcontainer.data.a
    @NotNull
    public CardType c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CardType) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return CardType.ImageNoButton;
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
