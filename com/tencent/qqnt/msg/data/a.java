package com.tencent.qqnt.msg.data;

import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.guild.message.msgtype.MessageRecordForMarkdown;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import com.tenpay.realname.RealNameSource;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 Z2\u00020\u0001:\u0001\tB\t\b\u0016\u00a2\u0006\u0004\bU\u0010VBc\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010W\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010X\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\bU\u0010YJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\b\u001a\u0004\u0018\u00010\u0004R$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR$\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR$\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u001b\u0010\u000eR$\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u001d\u0010\u000eR$\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\n\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR$\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\n\u001a\u0004\b\u001f\u0010\f\"\u0004\b$\u0010\u000eR$\u0010)\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\n\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000eR$\u0010,\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b+\u0010\u000eR$\u0010/\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\n\u001a\u0004\b*\u0010\f\"\u0004\b.\u0010\u000eR$\u00102\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\n\u001a\u0004\b&\u0010\f\"\u0004\b1\u0010\u000eR$\u00104\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\n\u001a\u0004\b0\u0010\f\"\u0004\b3\u0010\u000eR$\u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b-\u0010\f\"\u0004\b5\u0010\u000eR$\u00109\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\n\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR6\u0010A\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0018\u00010:j\n\u0012\u0004\u0012\u00020\u0000\u0018\u0001`;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010D\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\n\u001a\u0004\bB\u0010\f\"\u0004\bC\u0010\u000eR$\u0010G\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\n\u001a\u0004\bE\u0010\f\"\u0004\bF\u0010\u000eR\"\u0010J\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010T\u001a\u00020N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\b#\u0010Q\"\u0004\bR\u0010S\u00a8\u0006["}, d2 = {"Lcom/tencent/qqnt/msg/data/a;", "", "", "p", "", "data", "", "o", "r", "a", "Ljava/lang/String;", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", "setPromptText", "(Ljava/lang/String;)V", QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT, "b", "d", "setAppName", "appName", "c", "e", "setAppView", QQCustomArkDialogUtil.APP_VIEW, "f", "setBizSrc", ark.APP_SPECIFIC_BIZSRC, "setAppDesc", "appDesc", "setAppMinVersion", QQCustomArkDialogUtil.APP_MIN_VERSION, "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "metaList", tl.h.F, "setConfig", DownloadInfo.spKey_Config, "i", "getCompatibleText", "setCompatibleText", MessageRecordForMarkdown.MSG_MARKDOWN_COMPATIBLE_TEXT, "j", "setAppId", "appId", "k", "setMSourceName", "mSourceName", "l", "setMSourceActionData", "mSourceActionData", "setMSource_A_ActionData", "mSource_A_ActionData", "setMSourceUrl", "mSourceUrl", "getMText", "setMText", "mText", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getMAppList", "()Ljava/util/ArrayList;", "setMAppList", "(Ljava/util/ArrayList;)V", "mAppList", "getMSourceAd", "setMSourceAd", "mSourceAd", "getMExtra", "setMExtra", "mExtra", ReportConstant.COSTREPORT_PREFIX, "Z", ViewStickEventHelper.IS_SHOW, "()Z", "setShow", "(Z)V", "", "t", "I", "()I", "setFrom", "(I)V", "from", "<init>", "()V", "appMinVer", "metaListJson", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "u", "msg_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String promptText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String appName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String appView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String bizSrc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String appDesc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String appMinVersion;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String metaList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String config;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String compatibleText;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String appId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mSourceName;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mSourceActionData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mSource_A_ActionData;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mSourceUrl;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mText;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<a> mAppList;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mSourceAd;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mExtra;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean isShow;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private int from;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0004\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/msg/data/a$a;", "", "", "JsonActionData", "Ljava/lang/String;", "JsonActionData_A", "JsonAppDesc", "JsonAppId", "JsonAppMinVersion", "JsonAppName", "JsonAppView", "JsonApps", "JsonBizSrc", "JsonConfig", "JsonDetail", "JsonExtra", "JsonFrom", "JsonLink", "JsonLinkList", "JsonMetaList", "JsonPromptText", "JsonSourceAd", "JsonSourceName", "JsonSourceUrl", "JsonText", "KEY_MSG_SEQ", "TAG", "jsonIsShow", "<init>", "()V", "msg_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.msg.data.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38087);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 53)) {
            redirector.redirect((short) 53);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 47)) {
            p();
        } else {
            iPatchRedirector.redirect((short) 47, (Object) this);
        }
    }

    @Nullable
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.appDesc;
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.appId;
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.appMinVersion;
    }

    @Nullable
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.appName;
    }

    @Nullable
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.appView;
    }

    @Nullable
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.bizSrc;
    }

    @Nullable
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.config;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
        }
        return this.from;
    }

    @Nullable
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.mSourceActionData;
    }

    @Nullable
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.mSourceName;
    }

    @Nullable
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.mSourceUrl;
    }

    @Nullable
    public final String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.mSource_A_ActionData;
    }

    @Nullable
    public final String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.metaList;
    }

    @Nullable
    public final String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.promptText;
    }

    public final boolean o(@NotNull String data) {
        boolean z16;
        boolean z17;
        ArrayList<a> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this, (Object) data)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (TextUtils.isEmpty(data)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(data);
            this.appName = jSONObject.optString("app");
            this.appView = jSONObject.optString("view");
            this.bizSrc = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
            this.appDesc = jSONObject.optString("desc");
            this.appMinVersion = jSONObject.optString("ver");
            this.promptText = jSONObject.optString("prompt");
            this.metaList = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
            this.config = jSONObject.optString(DownloadInfo.spKey_Config);
            this.from = jSONObject.optInt("from");
            this.appId = jSONObject.optString("appID");
            this.mSourceName = jSONObject.optString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
            this.mSourceActionData = jSONObject.optString(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA);
            this.mSource_A_ActionData = jSONObject.optString("actionData_A");
            this.mSourceUrl = jSONObject.optString("sourceUrl");
            this.mAppList = new ArrayList<>();
            this.mText = jSONObject.optString("text");
            this.mExtra = jSONObject.optString("extra");
            JSONObject optJSONObject = jSONObject.optJSONObject(this.config);
            if (optJSONObject != null && optJSONObject.optInt("isshow", 0) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.isShow = z17;
            JSONArray optJSONArray = jSONObject.optJSONArray("extraApps");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject2 != null) {
                        a aVar = new a();
                        String jSONObject2 = optJSONObject2.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
                        if (aVar.o(jSONObject2) && (arrayList = this.mAppList) != null) {
                            arrayList.add(aVar);
                        }
                    }
                }
            }
            this.mSourceAd = jSONObject.optString("sourceAd");
            return true;
        } catch (JSONException e16) {
            QLog.e("ArkMsgModel", 1, "parse error = " + e16);
            return false;
        }
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this);
            return;
        }
        this.promptText = null;
        this.appName = null;
        this.appDesc = null;
        this.appView = null;
        this.bizSrc = null;
        this.appMinVersion = null;
        this.metaList = null;
        this.config = null;
        this.compatibleText = null;
    }

    public final void q(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else {
            this.metaList = str;
        }
    }

    @Nullable
    public final String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (String) iPatchRedirector.redirect((short) 51, (Object) this);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String str = this.appName;
            if (str != null) {
                jSONObject.put("app", str);
            }
            String str2 = this.appDesc;
            if (str2 != null) {
                jSONObject.put("desc", str2);
            }
            String str3 = this.appView;
            if (str3 != null) {
                jSONObject.put("view", str3);
            }
            String str4 = this.bizSrc;
            if (str4 != null) {
                jSONObject.put(QQCustomArkDialogUtil.BIZ_SRC, str4);
            }
            String str5 = this.appMinVersion;
            if (str5 != null) {
                jSONObject.put("ver", str5);
            }
            String str6 = this.promptText;
            if (str6 != null) {
                jSONObject.put("prompt", str6);
            }
            int i3 = this.from;
            if (i3 != 0) {
                jSONObject.put("from", i3);
            }
            String str7 = this.appId;
            if (str7 != null) {
                jSONObject.put("appID", str7);
            }
            String str8 = this.mSourceName;
            if (str8 != null) {
                jSONObject.put(RealNameSource.EXTRA_KEY_SOURCE_NAME, str8);
            }
            String str9 = this.mSourceActionData;
            if (str9 != null) {
                jSONObject.put(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA, str9);
            }
            String str10 = this.mSource_A_ActionData;
            if (str10 != null) {
                jSONObject.put("actionData_A", str10);
            }
            String str11 = this.mSourceUrl;
            if (str11 != null) {
                jSONObject.put("sourceUrl", str11);
            }
            if (this.metaList != null) {
                try {
                    String str12 = this.metaList;
                    Intrinsics.checkNotNull(str12);
                    jSONObject.put(PublicAccountMessageUtilImpl.META_NAME, new JSONObject(str12));
                } catch (Exception e16) {
                    QLog.e("ArkMsgModel", 1, "toAppXml fail, metaList, err=" + e16.getMessage());
                }
            }
            if (this.config != null) {
                try {
                    String str13 = this.config;
                    Intrinsics.checkNotNull(str13);
                    jSONObject.put(DownloadInfo.spKey_Config, new JSONObject(str13));
                } catch (Exception e17) {
                    QLog.e("ArkMsgModel", 1, "toAppXml fail, config, err=" + e17.getMessage());
                }
            }
            String str14 = this.mText;
            if (str14 != null) {
                jSONObject.put("text", str14);
            }
            if (this.mAppList != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    ArrayList<a> arrayList = this.mAppList;
                    Intrinsics.checkNotNull(arrayList);
                    Iterator<a> it = arrayList.iterator();
                    while (it.hasNext()) {
                        String r16 = it.next().r();
                        Intrinsics.checkNotNull(r16);
                        jSONArray.mo162put(new JSONObject(r16));
                    }
                    jSONObject.put("extraApps", jSONArray);
                } catch (Exception e18) {
                    QLog.e("ArkMsgModel", 1, "toAppXml fail, config, err=" + e18.getMessage());
                }
            }
            String str15 = this.mSourceAd;
            if (str15 != null) {
                jSONObject.put("sourceAd", str15);
            }
            String str16 = this.mExtra;
            if (str16 != null) {
                jSONObject.put("extra", str16);
            }
            return jSONObject.toString();
        } catch (Exception e19) {
            e19.printStackTrace();
            return null;
        }
    }

    public a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, str, str2, str3, str4, str5, str6, str7, str8, str9);
            return;
        }
        this.promptText = str;
        this.appDesc = str3;
        this.appName = str2;
        this.appView = str4;
        this.bizSrc = str5;
        this.appMinVersion = str6;
        this.metaList = str7;
        this.config = str8;
        this.compatibleText = str9;
    }
}
