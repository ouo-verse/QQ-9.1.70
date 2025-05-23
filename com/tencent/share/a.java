package com.tencent.share;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.f;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 L2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0005B\u000f\u0012\u0006\u0010,\u001a\u00020(\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001b\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0006\u0010\u0012\u001a\u00020\u0004J\u001c\u0010\u0016\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J5\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0006\u0010&\u001a\u00020%J\u0006\u0010'\u001a\u00020%R\u0017\u0010,\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010)\u001a\u0004\b*\u0010+R$\u00103\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00104R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\"\u0010C\u001a\u00020=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010I\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\b:\u0010F\"\u0004\bG\u0010H\u00a8\u0006M"}, d2 = {"Lcom/tencent/share/a;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "Landroid/content/DialogInterface$OnDismissListener;", "Lcom/tencent/mobileqq/colornote/f;", "", "a", "", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "b", "()[Ljava/util/List;", "c", "k", "Landroid/content/Intent;", h.F, "", "bizId", "l", "p", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "onItemClick", "", "action", "toUinType", "toUin", "toNickName", "d", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "e", "f", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "Lcom/tencent/mobileqq/colornote/data/ColorNote;", "getColorNote", "", DomainData.DOMAIN_NAME, "o", "Landroid/content/Context;", "Landroid/content/Context;", "getAct", "()Landroid/content/Context;", EventKey.ACT, "Lcom/tencent/share/b;", "Lcom/tencent/share/b;", "j", "()Lcom/tencent/share/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/share/b;)V", "webShare", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareDialogBuilder", "", "J", "shareSheetItemsRule", "Lcom/tencent/mobileqq/colornote/api/IColorNoteController;", "i", "Lcom/tencent/mobileqq/colornote/api/IColorNoteController;", "colorNoteController", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "g", "()Landroid/os/Bundle;", "setExtraParams", "(Landroid/os/Bundle;)V", QQBrowserActivity.APP_PARAM, BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "()Ljava/lang/String;", "setShareFrom", "(Ljava/lang/String;)V", "shareFrom", "<init>", "(Landroid/content/Context;)V", "D", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements ShareActionSheet.OnItemClickListener, DialogInterface.OnDismissListener, f {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String shareFrom;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context act;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b webShare;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ShareActionSheet shareDialogBuilder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long shareSheetItemsRule;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IColorNoteController colorNoteController;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Bundle extraParams;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/share/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.share.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes25.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64176);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull Context act) {
        Intrinsics.checkNotNullParameter(act, "act");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) act);
            return;
        }
        this.act = act;
        k();
        this.shareSheetItemsRule = 4L;
        this.extraParams = new Bundle();
        this.shareFrom = "general_url";
    }

    private final void a() {
        boolean z16;
        Context context = this.act;
        if (context instanceof Activity) {
            String stringExtra = ((Activity) context).getIntent().getStringExtra("big_brother_source_key");
            if (stringExtra != null) {
                if (stringExtra.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return;
                }
            }
            l("biz_src_zz_bodong");
        }
    }

    private final List<ShareActionSheetBuilder.ActionSheetItem>[] b() {
        AppRuntime appRuntime;
        ArrayList arrayList = new ArrayList();
        if (BaseApplicationImpl.getApplication().getRuntime() != null) {
            appRuntime = BaseApplicationImpl.getApplication().getRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime != null && !TextUtils.isEmpty(appRuntime.getAccount()) && (this.shareSheetItemsRule & 8) == 0) {
            ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(2);
            Intrinsics.checkNotNullExpressionValue(build, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_FRIEND)");
            arrayList.add(build);
        }
        if (appRuntime != null && !TextUtils.isEmpty(appRuntime.getAccount()) && (this.shareSheetItemsRule & 16) == 0) {
            ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(3);
            Intrinsics.checkNotNullExpressionValue(build2, "build(ShareActionSheetBu\u2026tem.ACTION_SEND_TO_QZONE)");
            arrayList.add(build2);
        }
        if (appRuntime != null && !TextUtils.isEmpty(appRuntime.getAccount()) && (this.shareSheetItemsRule & 16384) == 0) {
            ShareActionSheetBuilder.ActionSheetItem build3 = ShareActionSheetBuilder.ActionSheetItem.build(9);
            Intrinsics.checkNotNullExpressionValue(build3, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_WECHAT)");
            arrayList.add(build3);
        }
        if (appRuntime != null && !TextUtils.isEmpty(appRuntime.getAccount()) && (this.shareSheetItemsRule & 32768) == 0) {
            ShareActionSheetBuilder.ActionSheetItem build4 = ShareActionSheetBuilder.ActionSheetItem.build(10);
            Intrinsics.checkNotNullExpressionValue(build4, "build(ShareActionSheetBu\u2026ON_SEND_TO_WECHAT_CIRCLE)");
            arrayList.add(build4);
        }
        ArrayList arrayList2 = new ArrayList();
        if (n()) {
            Intrinsics.checkNotNullExpressionValue(ShareActionSheetBuilder.ActionSheetItem.build(70), "build(ShareActionSheetBu\u2026em.ACTION_ADD_COLOR_NOTE)");
        }
        if (o()) {
            Intrinsics.checkNotNullExpressionValue(ShareActionSheetBuilder.ActionSheetItem.build(82), "build(ShareActionSheetBu\u2026ACTION_REMOVE_COLOR_NOTE)");
        }
        if ((this.shareSheetItemsRule & 32) == 0) {
            Intrinsics.checkNotNullExpressionValue(ShareActionSheetBuilder.ActionSheetItem.build(1), "build(ShareActionSheetBu\u2026heetItem.ACTION_COPYLINK)");
        }
        Intrinsics.checkNotNullExpressionValue(ShareActionSheetBuilder.ActionSheetItem.build(11), "build(ShareActionSheetBu\u2026nSheetItem.ACTION_REPORT)");
        return new List[]{arrayList, arrayList2};
    }

    private final void c() {
        b bVar = this.webShare;
        if (bVar != null) {
            bVar.o();
        }
    }

    private final Intent h() {
        Intent intent = new Intent();
        intent.putExtra("forward_type", 1001);
        intent.putExtra("pluginName", "web_share");
        return intent;
    }

    private final void k() {
        Activity activity;
        IColorNoteController iColorNoteController = (IColorNoteController) QRoute.api(IColorNoteController.class);
        iColorNoteController.init(this.act, false, true);
        iColorNoteController.setServiceInfo(this);
        Context context = this.act;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            iColorNoteController.attachToActivity(activity);
        }
        this.colorNoteController = iColorNoteController;
    }

    public void d(int action, @Nullable Integer toUinType, @Nullable String toUin, @Nullable String toNickName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(action), toUinType, toUin, toNickName);
            return;
        }
        b bVar = this.webShare;
        if (bVar != null) {
            if (toUinType != null) {
                i3 = toUinType.intValue();
            }
            if (toUin == null) {
                toUin = "";
            }
            if (toNickName == null) {
                toNickName = "";
            }
            bVar.a(action, i3, toUin, toNickName);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        b bVar = this.webShare;
        if (bVar != null) {
            bVar.p();
        }
    }

    public void f(int action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, action);
            return;
        }
        b bVar = this.webShare;
        if (bVar != null) {
            bVar.u(action);
        }
    }

    @NotNull
    public final Bundle g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bundle) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.extraParams;
    }

    @Override // com.tencent.mobileqq.colornote.f
    @NotNull
    public ColorNote getColorNote() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ColorNote) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        ColorNote.a e16 = new ColorNote.a().g(R.id.background).i(QCircleLpReportDc010001.KEY_SUBTYPE).d("title").h(QQWinkConstants.TAB_SUBTITLE).e("coverUrl");
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        ColorNote a16 = e16.f(bytes).a();
        Intrinsics.checkNotNullExpressionValue(a16, "Builder().setServiceType\u2026).toByteArray()).create()");
        return a16;
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.shareFrom;
    }

    @Nullable
    public final b j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.webShare;
    }

    public void l(@NotNull String bizId) {
        Activity activity;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bizId);
            return;
        }
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Context context = this.act;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && (intent = activity.getIntent()) != null) {
            intent.putExtra("big_brother_source_key", bizId);
        }
    }

    public final void m(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            this.webShare = bVar;
        }
    }

    public final boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        IColorNoteController iColorNoteController = this.colorNoteController;
        if (iColorNoteController != null && iColorNoteController.shouldDisplayColorNote() && iColorNoteController.canAddColorNote() && !iColorNoteController.isColorNoteExist()) {
            return true;
        }
        return false;
    }

    public final boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        IColorNoteController iColorNoteController = this.colorNoteController;
        if (iColorNoteController != null && iColorNoteController.shouldDisplayColorNote() && iColorNoteController.isColorNoteExist()) {
            return true;
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(@Nullable DialogInterface dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) dialog);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(@Nullable ShareActionSheetBuilder.ActionSheetItem item, @Nullable ShareActionSheet shareActionSheet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) item, (Object) shareActionSheet);
            return;
        }
        if (item == null) {
            return;
        }
        ShareActionSheet shareActionSheet2 = this.shareDialogBuilder;
        if (shareActionSheet2 != null) {
            shareActionSheet2.dismiss();
        }
        if (item.action == 72) {
            this.extraParams.putString("to_qq", item.uin);
            this.extraParams.putString("to_uin_name", item.label);
            this.extraParams.putInt(ShortVideoConstants.TO_UIN_TYPE, item.uinType);
        }
        int i3 = item.action;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 9 && i3 != 10) {
                    if (i3 != 72 && i3 != 73) {
                        if (i3 == 171) {
                            c();
                            return;
                        }
                        return;
                    }
                } else {
                    f(i3);
                    return;
                }
            } else {
                e();
                return;
            }
        }
        d(i3, Integer.valueOf(item.uinType), item.uin, item.label);
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.shareDialogBuilder == null) {
            this.shareDialogBuilder = ShareActionSheetFactory.create(this.act, false);
        }
        ShareActionSheet shareActionSheet = this.shareDialogBuilder;
        if (shareActionSheet != null) {
            shareActionSheet.setIntentForStartForwardRecentActivity(h());
        }
        ShareActionSheet shareActionSheet2 = this.shareDialogBuilder;
        if (shareActionSheet2 != null) {
            shareActionSheet2.setActionSheetItems(b());
        }
        ShareActionSheet shareActionSheet3 = this.shareDialogBuilder;
        if (shareActionSheet3 != null) {
            shareActionSheet3.setItemClickListenerV2(this);
        }
        ShareActionSheet shareActionSheet4 = this.shareDialogBuilder;
        if (shareActionSheet4 != null) {
            shareActionSheet4.setOnDismissListener(this);
        }
        ShareActionSheet shareActionSheet5 = this.shareDialogBuilder;
        if (shareActionSheet5 != null) {
            shareActionSheet5.setRowVisibility(0, 0, 0);
        }
        a();
        try {
            ShareActionSheet shareActionSheet6 = this.shareDialogBuilder;
            if (shareActionSheet6 != null) {
                shareActionSheet6.show();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("CommonShareHelper", 2, "actionSheet.show exception=" + e16);
            }
        }
    }
}
