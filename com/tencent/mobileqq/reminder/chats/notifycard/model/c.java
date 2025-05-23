package com.tencent.mobileqq.reminder.chats.notifycard.model;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.ark.ark;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00109\u001a\u00020\u0001\u00a2\u0006\u0004\b:\u0010;J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001eR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00101\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0010\u001a\u0004\b/\u0010\u0012\"\u0004\b0\u0010\u0014R\"\u00105\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u0010\u001a\u0004\b3\u0010\u0012\"\u0004\b4\u0010\u0014R\"\u00108\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0010\u001a\u0004\b6\u0010\u0012\"\u0004\b7\u0010\u0014\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/model/c;", "Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/model/a;", "data", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "", BdhLogUtil.LogTag.Tag_Conn, "t", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/cardcontainer/data/a;", "other", "a", "", "l", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ljava/lang/String;", "D", "(Ljava/lang/String;)V", "selfNick", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/reminder/chats/notifycard/model/a;", "y", "()Lcom/tencent/mobileqq/reminder/chats/notifycard/model/a;", "mainActionButton", DomainData.DOMAIN_NAME, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setSubActionButton", "(Lcom/tencent/mobileqq/reminder/chats/notifycard/model/a;)V", "subActionButton", "", "o", "Ljava/util/List;", "B", "()Ljava/util/List;", "userUinList", "", "p", "I", "u", "()I", "setDataDate", "(I)V", "dataDate", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "w", "setHeadBgUrl", "headBgUrl", "r", HippyTKDListViewAdapter.X, "setHeadPendantUrl", "headPendantUrl", "v", "setDefaultReplyWording", "defaultReplyWording", "containerData", "<init>", "(Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;)V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c extends ContainerData {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String selfNick;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mainActionButton;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a subActionButton;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> userUinList;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int dataDate;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String headBgUrl;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String headPendantUrl;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String defaultReplyWording;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull ContainerData containerData) {
        super(containerData);
        Intrinsics.checkNotNullParameter(containerData, "containerData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) containerData);
            return;
        }
        this.selfNick = "";
        this.mainActionButton = new a(null, null, null, 7, null);
        this.userUinList = new ArrayList();
        this.headBgUrl = "";
        this.headPendantUrl = "";
        this.defaultReplyWording = "";
    }

    private final void C(a data, JSONObject json) {
        String optString = json.optString("text", "");
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"text\", \"\")");
        data.f(optString);
        String optString2 = json.optString(WadlProxyConsts.KEY_JUMP_URL, "");
        Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"jumpUrl\", \"\")");
        data.e(optString2);
        String optString3 = json.optString("iconUrl", "");
        Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"iconUrl\", \"\")");
        data.d(optString3);
    }

    @Nullable
    public final a A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.subActionButton;
    }

    @NotNull
    public final List<String> B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.userUinList;
    }

    public final void D(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.selfNick = str;
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.data.ContainerData, com.tencent.mobileqq.cardcontainer.data.a
    public boolean a(@NotNull com.tencent.mobileqq.cardcontainer.data.a other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) other)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(other, "other");
        if (!(other instanceof c) || !com.tencent.mobileqq.reminder.util.c.INSTANCE.b(this, (ContainerData) other) || !Intrinsics.areEqual(this.selfNick, ((c) other).selfNick)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.cardcontainer.data.ContainerData
    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return true;
    }

    public final void t() {
        boolean z16;
        JSONObject optJSONObject;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        this.userUinList.clear();
        this.mainActionButton.c();
        this.subActionButton = null;
        ArrayList<com.tencent.mobileqq.cardcontainer.data.b> h16 = h();
        if (h16 != null) {
            Iterator<com.tencent.mobileqq.cardcontainer.data.b> it = h16.iterator();
            while (it.hasNext()) {
                String h17 = it.next().h();
                if (h17 != null && h17.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    this.userUinList.add(h17);
                }
            }
        }
        String o16 = o();
        if (o16 != null && o16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(o());
            this.dataDate = jSONObject.optInt("dataDate", 0);
            String optString = jSONObject.optString("headPendantUrl", "");
            Intrinsics.checkNotNullExpressionValue(optString, "extJson.optString(\"headPendantUrl\", \"\")");
            this.headPendantUrl = optString;
            String optString2 = jSONObject.optString("headBgUrl", "");
            Intrinsics.checkNotNullExpressionValue(optString2, "extJson.optString(\"headBgUrl\", \"\")");
            this.headBgUrl = optString2;
            String optString3 = jSONObject.optString("nick", "");
            Intrinsics.checkNotNullExpressionValue(optString3, "extJson.optString(\"nick\", \"\")");
            this.selfNick = optString3;
            String optString4 = jSONObject.optString("defaultReplyWording", "");
            Intrinsics.checkNotNullExpressionValue(optString4, "extJson.optString(\"defaultReplyWording\", \"\")");
            this.defaultReplyWording = optString4;
            JSONArray optJSONArray = jSONObject.optJSONArray("actionButtonList");
            if (optJSONArray != null && optJSONArray.length() >= 1) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(0);
                if (optJSONObject2 != null) {
                    C(this.mainActionButton, optJSONObject2);
                }
                if (optJSONArray.length() >= 2 && (optJSONObject = optJSONArray.optJSONObject(1)) != null) {
                    a aVar = new a(null, null, null, 7, null);
                    C(aVar, optJSONObject);
                    this.subActionButton = aVar;
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public final int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.dataDate;
    }

    @NotNull
    public final String v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.defaultReplyWording;
    }

    @NotNull
    public final String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.headBgUrl;
    }

    @NotNull
    public final String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.headPendantUrl;
    }

    @NotNull
    public final a y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mainActionButton;
    }

    @NotNull
    public final String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.selfNick;
    }
}
