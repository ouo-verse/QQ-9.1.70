package com.tencent.mobileqq.reminder.chats.notifycard.model;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010>\u001a\u00020\u0001\u00a2\u0006\u0004\b?\u0010@J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010 \u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\"\u0010$\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR\"\u0010(\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\"\u0010/\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00106\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R'\u0010=\u001a\u0012\u0012\u0004\u0012\u00020807j\b\u0012\u0004\u0012\u000208`98\u0006\u00a2\u0006\f\n\u0004\b\"\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/model/b;", "Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", "", "t", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/cardcontainer/data/a;", "other", "a", "", "l", "Ljava/lang/String;", "B", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", QQWinkConstants.TAB_SUBTITLE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "v", "setBtnTitle", "btnTitle", DomainData.DOMAIN_NAME, "y", "setHeadBgUrl", "headBgUrl", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "setHeadPendantUrl", "headPendantUrl", "p", "getBtnIcon", "setBtnIcon", "btnIcon", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "setBtnBgUrl", "btnBgUrl", "r", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setJumpUrl", WadlProxyConsts.KEY_JUMP_URL, "", "J", HippyTKDListViewAdapter.X, "()J", "D", "(J)V", "expiredTime", "", "I", "w", "()I", "setDataDate", "(I)V", "dataDate", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/model/d;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "()Ljava/util/ArrayList;", "userList", "containerData", "<init>", "(Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;)V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b extends ContainerData {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String subTitle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String btnTitle;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String headBgUrl;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String headPendantUrl;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String btnIcon;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String btnBgUrl;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String jumpUrl;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private long expiredTime;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private int dataDate;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<d> userList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull ContainerData containerData) {
        super(containerData);
        Intrinsics.checkNotNullParameter(containerData, "containerData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) containerData);
            return;
        }
        this.subTitle = "";
        this.btnTitle = "";
        this.headBgUrl = "";
        this.headPendantUrl = "";
        this.btnIcon = "";
        this.btnBgUrl = "";
        this.jumpUrl = "";
        this.userList = new ArrayList<>();
    }

    @NotNull
    public final String A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.jumpUrl;
    }

    @NotNull
    public final String B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.subTitle;
    }

    @NotNull
    public final ArrayList<d> C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ArrayList) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.userList;
    }

    public final void D(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, j3);
        } else {
            this.expiredTime = j3;
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.data.ContainerData, com.tencent.mobileqq.cardcontainer.data.a
    public boolean a(@NotNull com.tencent.mobileqq.cardcontainer.data.a other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) other)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(other, "other");
        if (!(other instanceof ContainerData)) {
            return false;
        }
        return com.tencent.mobileqq.reminder.util.c.INSTANCE.b(this, (ContainerData) other);
    }

    @Override // com.tencent.mobileqq.cardcontainer.data.ContainerData
    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return true;
    }

    public final void t() {
        boolean z16;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        String o16 = o();
        if (o16 != null && o16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            try {
                JSONObject jSONObject = new JSONObject(o());
                String optString = jSONObject.optString("boxSubTitle", "");
                Intrinsics.checkNotNullExpressionValue(optString, "extJson.optString(\"boxSubTitle\", \"\")");
                this.subTitle = optString;
                this.dataDate = jSONObject.optInt("dataDate", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("button");
                String str3 = null;
                if (optJSONObject != null) {
                    str = optJSONObject.optString("text", "");
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                this.btnTitle = str;
                if (optJSONObject != null) {
                    str2 = optJSONObject.optString("iconUrl", "");
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    str2 = "";
                }
                this.btnIcon = str2;
                if (optJSONObject != null) {
                    str3 = optJSONObject.optString("backgroundUrl", "");
                }
                if (str3 == null) {
                    str3 = "";
                }
                this.btnBgUrl = str3;
                String optString2 = jSONObject.optString("jump_url", "");
                Intrinsics.checkNotNullExpressionValue(optString2, "extJson.optString(\"jump_url\", \"\")");
                this.jumpUrl = optString2;
                String optString3 = jSONObject.optString("headBgUrl", "");
                Intrinsics.checkNotNullExpressionValue(optString3, "extJson.optString(\"headBgUrl\", \"\")");
                this.headBgUrl = optString3;
                String optString4 = jSONObject.optString("headPendantUrl", "");
                Intrinsics.checkNotNullExpressionValue(optString4, "extJson.optString(\"headPendantUrl\", \"\")");
                this.headPendantUrl = optString4;
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    @NotNull
    public final String u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.btnBgUrl;
    }

    @NotNull
    public final String v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.btnTitle;
    }

    public final int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.dataDate;
    }

    public final long x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return this.expiredTime;
    }

    @NotNull
    public final String y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.headBgUrl;
    }

    @NotNull
    public final String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.headPendantUrl;
    }
}
