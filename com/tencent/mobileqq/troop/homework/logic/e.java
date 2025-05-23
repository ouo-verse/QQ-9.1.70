package com.tencent.mobileqq.troop.homework.logic;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.homework.config.PublishHwkThirdPartyEntryConfigParser;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 H2\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010 \u001a\u00020\u001c\u0012\u0006\u0010%\u001a\u00020!\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0006H\u0016J\"\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0006H\u0016R\u0017\u0010 \u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010%\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\"\u001a\u0004\b#\u0010$R\u001f\u0010+\u001a\n '*\u0004\u0018\u00010&0&8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010(\u001a\u0004\b)\u0010*R\u001f\u00101\u001a\n '*\u0004\u0018\u00010,0,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001f\u00107\u001a\n '*\u0004\u0018\u000102028\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010\"R\u0016\u0010@\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010\"R\u0016\u0010C\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010\"\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/logic/e;", "Lcom/tencent/mobileqq/troop/homework/logic/a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "a", "", "c", "bSel", "p", "", "id", "f", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lorg/json/JSONArray;", "retArray", "b", "Lorg/json/JSONObject;", "jsObj", "d", "from", "g", "isInputMethodActive", "e", "Lcom/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment;", "Lcom/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment;", "getHost", "()Lcom/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment;", "host", "", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "troopUin", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "Landroid/widget/LinearLayout;", "getDocsLinkLayout", "()Landroid/widget/LinearLayout;", "docsLinkLayout", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "getDocsLinkText", "()Landroid/widget/TextView;", "docsLinkText", "Landroid/view/View;", "i", "Landroid/view/View;", "getDocsLinkCloseBtn", "()Landroid/view/View;", "docsLinkCloseBtn", "Z", "isSelected", BdhLogUtil.LogTag.Tag_Conn, "Lorg/json/JSONObject;", "oldJson", "D", "examId", "E", "strCourseName", UserInfo.SEX_FEMALE, "I", "questionNum", "G", "strTitle", "<init>", "(Lcom/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment;Ljava/lang/String;)V", "H", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private JSONObject oldJson;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String examId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String strCourseName;

    /* renamed from: F, reason: from kotlin metadata */
    private int questionNum;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String strTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PublishHomeWorkFragment host;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout docsLinkLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final TextView docsLinkText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final View docsLinkCloseBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isSelected;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/logic/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.logic.e$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52235);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(@NotNull PublishHomeWorkFragment host, @NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) host, (Object) troopUin);
            return;
        }
        this.host = host;
        this.troopUin = troopUin;
        LinearLayout linearLayout = (LinearLayout) host.findViewById(R.id.f101965wm);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.logic.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.l(e.this, view);
            }
        });
        this.docsLinkLayout = linearLayout;
        this.docsLinkText = (TextView) linearLayout.findViewById(R.id.f1041062e);
        View findViewById = linearLayout.findViewById(R.id.f101565vj);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.logic.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.k(e.this, view);
            }
        });
        this.docsLinkCloseBtn = findViewById;
        this.examId = "";
        this.strCourseName = "";
        this.strTitle = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void m() {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("DocsEntranceHelper", 2, "onClickDocsLink");
        }
        com.tencent.mobileqq.troop.homework.config.a c16 = PublishHwkThirdPartyEntryConfigParser.c();
        if (c16 != null) {
            String strJumpUrl = c16.a();
            Intrinsics.checkNotNullExpressionValue(strJumpUrl, "strJumpUrl");
            if (strJumpUrl.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            String str = strJumpUrl + "?gc=" + this.troopUin + "&appid=101458937&examid=" + this.examId + "&_wwv=128&_wv=3";
            Intrinsics.checkNotNullExpressionValue(str, "stringBuilder.toString()");
            Intent intent = new Intent();
            intent.putExtra("url", str);
            RouteUtils.startActivity(this.host.getActivity(), intent, RouterConstants.UI_ROUTE_BROWSER);
            if (this.host.Lh() != null) {
                this.host.Lh().B();
            }
        }
    }

    private final void n() {
        p(false);
        LinearLayout linearLayout = this.docsLinkLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        this.host.Ci(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.docsLinkLayout.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        LinearLayout linearLayout = this.docsLinkLayout;
        Boolean valueOf = Boolean.valueOf(this.isSelected);
        linearLayout.setVisibility(0);
        if (((View) au.a(valueOf, linearLayout)) == null) {
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void b(@Nullable JSONArray retArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) retArray);
            return;
        }
        if (retArray == null) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("TencentDocEntranceHelper", "onPublishHomework but retArray is null, return");
            return;
        }
        if (this.isSelected) {
            Object obj = this.oldJson;
            if (obj != null) {
                retArray.mo162put(obj);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "exam");
                jSONObject.put("exam_type", "1");
                jSONObject.put("appid", "101458937");
                jSONObject.put("exam_id", this.examId);
                jSONObject.put(Element.ELEMENT_NAME_COURSE_NAME, this.strCourseName);
                jSONObject.put("exam_count", String.valueOf(this.questionNum));
                jSONObject.put("title", this.strTitle);
                retArray.mo162put(jSONObject);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isSelected;
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void d(@Nullable JSONObject jsObj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) jsObj);
            return;
        }
        if (jsObj == null) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("TencentDocEntranceHelper", "onHandlerModifyHWInfo but jsObj is null, return");
            return;
        }
        String optString = jsObj.optString("type");
        String optString2 = jsObj.optString("exam_type");
        String optString3 = jsObj.optString("appid");
        if (Intrinsics.areEqual(optString, "exam") && !Intrinsics.areEqual(optString2, "0") && Intrinsics.areEqual(optString3, "101458937")) {
            this.oldJson = jsObj;
            this.docsLinkText.setText(jsObj.optString("title"));
            String optString4 = jsObj.optString("exam_id");
            Intrinsics.checkNotNullExpressionValue(optString4, "jsObj.optString(\"exam_id\")");
            this.examId = optString4;
            this.docsLinkLayout.setVisibility(0);
            this.docsLinkLayout.setClickable(false);
            this.docsLinkCloseBtn.setVisibility(8);
            p(true);
            this.host.Ci(2);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void e(boolean isInputMethodActive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, isInputMethodActive);
        } else {
            if (!this.isSelected) {
                return;
            }
            if (isInputMethodActive) {
                this.docsLinkLayout.setVisibility(8);
            } else {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.logic.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.o(e.this);
                    }
                }, 20L);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void f(int id5, boolean bSel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(id5), Boolean.valueOf(bSel));
            return;
        }
        if (id5 != 2) {
            LinearLayout linearLayout = this.docsLinkLayout;
            Boolean valueOf = Boolean.valueOf(!bSel);
            linearLayout.setVisibility(0);
            if (((View) au.a(valueOf, linearLayout)) == null) {
                linearLayout.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void g(int from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, from);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
        }
    }

    public void p(boolean bSel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, bSel);
        } else {
            this.isSelected = bSel;
        }
    }
}
