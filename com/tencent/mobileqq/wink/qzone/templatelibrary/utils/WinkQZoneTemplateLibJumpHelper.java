package com.tencent.mobileqq.wink.qzone.templatelibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import androidx.fragment.app.Fragment;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.MaterialType;
import com.tencent.mobileqq.wink.f;
import com.tencent.mobileqq.wink.picker.g;
import com.tencent.mobileqq.wink.qzone.templatelibrary.fragment.WinkQZoneTemplateLibDetailFragment;
import com.tencent.mobileqq.wink.templatelibrary.jump.TemplateJumpImpl;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.util.URLUtil;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCStatus$GetStatusReply;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00052\u00020\u0001:\u0001.B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010B\u001a\u0004\u0018\u000106\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\r\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u001a\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\u0006\u0010\u0019\u001a\u00020\tJ-\u0010 \u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001a2\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J.\u0010$\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u000f\u001a\u00020\u0002J4\u0010%\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020&R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001c\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u000106058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010A\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "", "", "preActivityName", "", h.F, "Landroid/content/Context;", "context", ZPlanPublishSource.FROM_SCHEME, "", "p", "Landroid/os/Bundle;", "bundle", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "comeFrom", "l", "Landroid/content/Intent;", "intent", "i", "r", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "template", "u", "g", "t", "", "requestCode", "", "permissions", "", "grantResults", ReportConstant.COSTREPORT_PREFIX, "(I[Ljava/lang/String;[I)V", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "currentCategory", DomainData.DOMAIN_NAME, "k", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "a", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "loadingDialog", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "b", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "Lcom/tencent/mobileqq/wink/templatelibrary/jump/TemplateJumpImpl;", "c", "Lcom/tencent/mobileqq/wink/templatelibrary/jump/TemplateJumpImpl;", "videoTemplateJump", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "Landroidx/fragment/app/Fragment;", "d", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "fragmentRef", "Lqshadow/ShadowAIGCStatus$GetStatusReply;", "e", "Lqshadow/ShadowAIGCStatus$GetStatusReply;", "magicButtonInfo", "f", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "selectedTemplate", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "fragment", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkQZoneTemplateLibJumpHelper {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Set<String> f326218i;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleCommonLoadingDialog loadingDialog;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQPermission qqPermission;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TemplateJumpImpl videoTemplateJump;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.avatar.meta.refresh.c<Fragment> fragmentRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ShadowAIGCStatus$GetStatusReply magicButtonInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MetaMaterial selectedTemplate;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MetaCategory currentCategory;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper$a", "Lcom/tencent/mobileqq/wink/templatelibrary/jump/b;", "", "a", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements com.tencent.mobileqq.wink.templatelibrary.jump.b {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.templatelibrary.jump.b
        public boolean a() {
            return true;
        }

        @Override // com.tencent.mobileqq.wink.templatelibrary.jump.b
        @Nullable
        public QQPermission b() {
            return WinkQZoneTemplateLibJumpHelper.this.qqPermission;
        }
    }

    static {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName(), QZoneHelper.UPLOAD_PHOTO, QZoneHelper.COMMON_UPLOAD});
        f326218i = of5;
    }

    public WinkQZoneTemplateLibJumpHelper(@NotNull Context context, @Nullable Fragment fragment) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.fragmentRef = new com.tencent.qqnt.avatar.meta.refresh.c<>(fragment);
        this.magicButtonInfo = new ShadowAIGCStatus$GetStatusReply();
        if (fragment != null) {
            this.qqPermission = QQPermissionFactory.getQQPermission(fragment);
        }
        this.videoTemplateJump = new TemplateJumpImpl(context, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.loadingDialog;
        if (qCircleCommonLoadingDialog != null) {
            Intrinsics.checkNotNull(qCircleCommonLoadingDialog);
            if (qCircleCommonLoadingDialog.isShowing()) {
                QCircleCommonLoadingDialog qCircleCommonLoadingDialog2 = this.loadingDialog;
                Intrinsics.checkNotNull(qCircleCommonLoadingDialog2);
                qCircleCommonLoadingDialog2.dismiss();
            }
        }
    }

    private final boolean h(String preActivityName) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        String name = ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "api(IQZoneRouteApi::clas\u2026ishMoodActivityClass.name");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) preActivityName, false, 2, (Object) null);
        if (!contains$default) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) QZoneHelper.UPLOAD_PHOTO, (CharSequence) preActivityName, false, 2, (Object) null);
            if (!contains$default2) {
                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) QZoneHelper.COMMON_UPLOAD, (CharSequence) preActivityName, false, 2, (Object) null);
                if (!contains$default3) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void i(Context context, Intent intent) {
        Bundle bundle;
        HashMap hashMapOf;
        Bundle bundle2 = new Bundle();
        String str = null;
        if (intent != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        bundle2.putAll(bundle);
        bundle2.putBoolean(QQWinkConstants.QZONE_TEMPLATE_LIB_IS_IMAGE_TEMPLATE, true);
        Pair[] pairArr = new Pair[1];
        MetaMaterial metaMaterial = this.selectedTemplate;
        if (metaMaterial != null) {
            str = metaMaterial.f30533id;
        }
        pairArr[0] = TuplesKt.to("template", str);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        bundle2.putSerializable("key_attrs", hashMapOf);
        g.f324860a.e(context, bundle2);
    }

    private final void j(Context context, Bundle bundle) {
        String str;
        MetaMaterial metaMaterial = this.selectedTemplate;
        if (metaMaterial != null) {
            str = metaMaterial.f30533id;
        } else {
            str = null;
        }
        w53.b.f("WinkQZoneTemplateLibJumpHelper", "jumpToCameraPage " + str);
        if (this.selectedTemplate != null && bundle != null) {
            bundle.putInt("JUMP_FROM_KEY", 104);
            MetaMaterial metaMaterial2 = this.selectedTemplate;
            Intrinsics.checkNotNull(metaMaterial2);
            f83.a.b(context, metaMaterial2, bundle);
        }
    }

    private final void l(Context context, String comeFrom) {
        String str;
        MetaMaterial metaMaterial = this.selectedTemplate;
        String str2 = null;
        if (metaMaterial != null) {
            str = com.tencent.mobileqq.wink.editor.c.t(metaMaterial);
        } else {
            str = null;
        }
        w53.b.f("WinkQZoneTemplateLibJumpHelper", "jumpToMagicStudioDetailPage " + str);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            Intent intent = activity.getIntent();
            if (intent != null) {
                intent.putExtra("come_from", comeFrom);
            }
            IQQWinkMagicStudioApi iQQWinkMagicStudioApi = (IQQWinkMagicStudioApi) QRoute.api(IQQWinkMagicStudioApi.class);
            MetaMaterial metaMaterial2 = this.selectedTemplate;
            if (metaMaterial2 != null) {
                str2 = com.tencent.mobileqq.wink.editor.c.t(metaMaterial2);
            }
            iQQWinkMagicStudioApi.jumpToMagicStudioFragment(activity, str2, this.currentCategory);
        }
    }

    public static /* synthetic */ void o(WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper, Context context, MetaMaterial metaMaterial, MetaCategory metaCategory, String str, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            metaCategory = null;
        }
        winkQZoneTemplateLibJumpHelper.n(context, metaMaterial, metaCategory, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0197, code lost:
    
        if (r3 == true) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x008a, code lost:
    
        if (h(r3) != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void p(Context context, String scheme) {
        String str;
        Activity activity;
        String str2;
        String str3;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Uri parse;
        String queryParameter;
        String queryParameter2;
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        Intent intent;
        boolean z26 = context instanceof Activity;
        if (z26) {
            Activity activity2 = (Activity) context;
            str = activity2.getIntent().getStringExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME);
            if (!f326218i.contains(str)) {
                str = activity2.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            }
        } else {
            str = null;
        }
        if (z26) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null || (intent = activity.getIntent()) == null || (str2 = intent.getStringExtra(QQWinkConstants.KEY_PREVIOUS_ACTIVITY)) == null) {
            str2 = "EmptyAct";
        }
        String str4 = "";
        String str5 = "1";
        boolean z27 = true;
        if (!h(str2)) {
            str3 = "0";
            if (z26) {
                Activity activity3 = (Activity) context;
                String stringExtra = activity3.getIntent().getStringExtra("key_scheme");
                if (stringExtra != null && stringExtra.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    String stringExtra2 = activity3.getIntent().getStringExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME);
                    if (stringExtra2 == null) {
                        stringExtra2 = "";
                    }
                }
            }
            if (str2.length() != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 || !Intrinsics.areEqual(str, QZoneHelper.COMMON_UPLOAD)) {
                str5 = str3;
            }
            w53.b.a("WinkQZoneTemplateLibJumpHelper", "destClass: " + str + ", preActivityName: " + str2 + ", isOpenedPublisher: " + ((Object) str5));
            if (scheme != null) {
                startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(scheme, "mqqapi://qzoneschema/?schema=", false, 2, null);
                if (startsWith$default3) {
                    z18 = true;
                    if (!z18 && f326218i.contains(str)) {
                        try {
                            byte[] decode = Base64.decode(URLUtil.getArgumentsFromURL(scheme).get(QZoneDTLoginReporter.SCHEMA), 2);
                            Intrinsics.checkNotNullExpressionValue(decode, "decode(base64Str, Base64.NO_WRAP)");
                            Charset forName = Charset.forName("utf-8");
                            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
                            str4 = new String(decode, forName);
                        } catch (Exception e16) {
                            w53.b.d("WinkQZoneTemplateLibJumpHelper", "decode schema error", e16);
                        }
                        String builder = Uri.parse(str4).buildUpon().appendQueryParameter("PhotoConst.INIT_ACTIVITY_CLASS_NAME", str).appendQueryParameter("isOpenedPublisher", str5).toString();
                        Intrinsics.checkNotNullExpressionValue(builder, "parse(decodedAction).bui\u2026enedPublisher).toString()");
                        byte[] bytes = builder.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                        f.l(context, "mqqapi://qzoneschema/?schema=" + Base64.encodeToString(bytes, 2));
                        return;
                    }
                    if (scheme != null) {
                        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(scheme, "mqqapi://qcircle/openwebview?url=", false, 2, null);
                        if (startsWith$default2) {
                            z19 = true;
                            if (!z19 && ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
                                QCircleToast.m(QCircleToast.f91644d, context.getResources().getString(R.string.f185153nt), 0, true, true, 150L, 0);
                                return;
                            }
                            if (scheme != null) {
                                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(scheme, "mqqapi://qcircle/openwebview?url=", false, 2, null);
                            }
                            z27 = false;
                            if (!z27 && (queryParameter = (parse = Uri.parse(scheme)).getQueryParameter("url")) != null) {
                                String uri = Uri.parse(queryParameter).buildUpon().appendQueryParameter("isOpenedPublisher", str5).build().toString();
                                Intrinsics.checkNotNullExpressionValue(uri, "parse(it).buildUpon()\n  \u2026      .build().toString()");
                                Uri.Builder buildUpon = parse.buildUpon();
                                buildUpon.clearQuery();
                                buildUpon.appendQueryParameter("url", uri);
                                for (String str6 : parse.getQueryParameterNames()) {
                                    if (!str6.equals("url") && (queryParameter2 = parse.getQueryParameter(str6)) != null) {
                                        buildUpon.appendQueryParameter(str6, queryParameter2);
                                    }
                                }
                                String uri2 = buildUpon.build().toString();
                                Intrinsics.checkNotNullExpressionValue(uri2, "schemeBuilder.build().toString()");
                                f.l(context, uri2);
                                return;
                            }
                            f.l(context, scheme);
                        }
                    }
                    z19 = false;
                    if (!z19) {
                    }
                    if (scheme != null) {
                    }
                    z27 = false;
                    if (!z27) {
                    }
                    f.l(context, scheme);
                }
            }
            z18 = false;
            if (!z18) {
            }
            if (scheme != null) {
            }
            z19 = false;
            if (!z19) {
            }
            if (scheme != null) {
            }
            z27 = false;
            if (!z27) {
            }
            f.l(context, scheme);
        }
        str3 = "1";
        if (str2.length() != 0) {
        }
        if (z17) {
        }
        str5 = str3;
        w53.b.a("WinkQZoneTemplateLibJumpHelper", "destClass: " + str + ", preActivityName: " + str2 + ", isOpenedPublisher: " + ((Object) str5));
        if (scheme != null) {
        }
        z18 = false;
        if (!z18) {
        }
        if (scheme != null) {
        }
        z19 = false;
        if (!z19) {
        }
        if (scheme != null) {
        }
        z27 = false;
        if (!z27) {
        }
        f.l(context, scheme);
    }

    private final void q(Context context, Bundle bundle) {
        String str;
        MetaMaterial metaMaterial = this.selectedTemplate;
        String str2 = null;
        if (metaMaterial != null) {
            str = metaMaterial.f30533id;
        } else {
            str = null;
        }
        w53.b.f("WinkQZoneTemplateLibJumpHelper", "jumpToTemplateDetailPage " + str);
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", WinkQZoneTemplateLibDetailFragment.class.getName());
        intent.putExtra("current_material_category", this.currentCategory);
        MetaMaterial metaMaterial2 = this.selectedTemplate;
        if (metaMaterial2 != null) {
            str2 = metaMaterial2.f30533id;
        }
        intent.putExtra("target_template_id", str2);
        context.startActivity(intent);
    }

    private final void r(Context context, Intent intent) {
        boolean z16;
        if (this.selectedTemplate == null) {
            w53.b.c("WinkQZoneTemplateLibJumpHelper", "jumpVideoTemplatePickerPage selectedTemplate is null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("JUMP_FROM_KEY", 104);
        String stringExtra = intent.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
        if (stringExtra != null && stringExtra.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            stringExtra = WinkContext.INSTANCE.g();
        }
        MetaMaterial metaMaterial = this.selectedTemplate;
        Intrinsics.checkNotNull(metaMaterial);
        f83.a.d(metaMaterial, stringExtra, bundle, this.videoTemplateJump, new c(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(Context context, final MetaMaterial template) {
        QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(context).p(context.getString(R.string.f241327rk)).n(false).a();
        this.loadingDialog = a16;
        Intrinsics.checkNotNull(a16);
        a16.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.utils.a
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                WinkQZoneTemplateLibJumpHelper.v(WinkQZoneTemplateLibJumpHelper.this, template, dialogInterface);
            }
        });
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.loadingDialog;
        Intrinsics.checkNotNull(qCircleCommonLoadingDialog);
        qCircleCommonLoadingDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(WinkQZoneTemplateLibJumpHelper this$0, MetaMaterial template, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(template, "$template");
        TemplateJumpImpl templateJumpImpl = this$0.videoTemplateJump;
        if (templateJumpImpl != null) {
            templateJumpImpl.f(template.f30533id);
        }
    }

    public final void k(@NotNull Context context, @Nullable Bundle bundle, @Nullable MetaMaterial template, @Nullable MetaCategory currentCategory, @NotNull String comeFrom) {
        String str;
        boolean z16;
        MaterialType materialType;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(comeFrom, "comeFrom");
        this.selectedTemplate = template;
        this.currentCategory = currentCategory;
        String str2 = null;
        if (r93.h.f430993a.g()) {
            MetaMaterial metaMaterial = this.selectedTemplate;
            if (metaMaterial != null) {
                materialType = com.tencent.mobileqq.wink.editor.c.T(metaMaterial);
            } else {
                materialType = null;
            }
            if (materialType == MaterialType.CAMERA) {
                j(context, bundle);
                return;
            }
        }
        MetaMaterial metaMaterial2 = this.selectedTemplate;
        if (metaMaterial2 != null) {
            str = com.tencent.mobileqq.wink.editor.c.m0(metaMaterial2);
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            MetaMaterial metaMaterial3 = this.selectedTemplate;
            if (metaMaterial3 != null) {
                str2 = com.tencent.mobileqq.wink.editor.c.m0(metaMaterial3);
            }
            p(context, str2);
            return;
        }
        MetaMaterial metaMaterial4 = this.selectedTemplate;
        if (metaMaterial4 != null) {
            str2 = com.tencent.mobileqq.wink.editor.c.o(metaMaterial4);
        }
        if (Intrinsics.areEqual(str2, "pic_gen_pic")) {
            l(context, comeFrom);
        } else {
            q(context, bundle);
        }
    }

    public final void m(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Fragment fragment = this.fragmentRef.get();
        if (fragment == null) {
            w53.b.c("WinkQZoneTemplateLibJumpHelper", "jumpToMagicStudio fragment is null");
            return;
        }
        if (this.selectedTemplate == null) {
            w53.b.c("WinkQZoneTemplateLibJumpHelper", "jumpToMagicStudio selectedTemplate is null");
            return;
        }
        IQQWinkMagicStudioApi iQQWinkMagicStudioApi = (IQQWinkMagicStudioApi) QRoute.api(IQQWinkMagicStudioApi.class);
        MetaMaterial metaMaterial = this.selectedTemplate;
        Intrinsics.checkNotNull(metaMaterial);
        iQQWinkMagicStudioApi.handleMagicStudioStyleOnClick(activity, fragment, metaMaterial, this.magicButtonInfo, this.currentCategory);
    }

    public final void n(@Nullable Context context, @Nullable MetaMaterial template, @Nullable MetaCategory currentCategory, @NotNull String comeFrom) {
        boolean z16;
        Bundle bundle;
        Intrinsics.checkNotNullParameter(comeFrom, "comeFrom");
        this.selectedTemplate = template;
        this.currentCategory = currentCategory;
        if (!(context instanceof Activity)) {
            w53.b.c("WinkQZoneTemplateLibJumpHelper", "handleJump context is not Activity");
            return;
        }
        if (template == null) {
            w53.b.c("WinkQZoneTemplateLibJumpHelper", "handleJump template is null");
            return;
        }
        if (com.tencent.mobileqq.wink.editor.c.T(template) == MaterialType.CAMERA) {
            Intent intent = ((Activity) context).getIntent();
            if (intent != null) {
                bundle = intent.getExtras();
            } else {
                bundle = null;
            }
            j(context, bundle);
            return;
        }
        if (com.tencent.mobileqq.wink.editor.c.m0(template).length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            p(context, com.tencent.mobileqq.wink.editor.c.m0(template));
            return;
        }
        if (com.tencent.mobileqq.wink.editor.c.b1(template)) {
            i(context, ((Activity) context).getIntent());
            return;
        }
        if (Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.o(template), "pic_gen_pic")) {
            if (this.magicButtonInfo.button_info.type.get() == 3) {
                m((Activity) context);
                return;
            } else {
                l(context, comeFrom);
                return;
            }
        }
        Intent intent2 = ((Activity) context).getIntent();
        Intrinsics.checkNotNullExpressionValue(intent2, "context.intent");
        r(context, intent2);
    }

    public final void s(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        QQPermission qQPermission = this.qqPermission;
        if (qQPermission != null) {
            qQPermission.onRequestPermissionResult(requestCode, permissions, grantResults);
        }
    }

    public final void t() {
        ((IQQWinkMagicStudioApi) QRoute.api(IQQWinkMagicStudioApi.class)).requestMagicStudioButtonInfo(1, new WinkQZoneTemplateLibJumpHelper$requestMagicStudioInfo$1(this));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper$c", "Lcom/tencent/mobileqq/wink/templatelibrary/jump/a;", "", "onDownloadStart", "", "isSuccess", "", "code", "b", EventListener.KEY_DELTA, "onProgressUpdate", "c", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements com.tencent.mobileqq.wink.templatelibrary.jump.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f326228b;

        c(Context context) {
            this.f326228b = context;
        }

        @Override // com.tencent.mobileqq.wink.templatelibrary.jump.a
        public boolean a() {
            return false;
        }

        @Override // com.tencent.mobileqq.wink.templatelibrary.jump.a
        public void b(boolean isSuccess, int code) {
            w53.b.f("WinkQZoneTemplateLibJumpHelper", "jumpVideoTemplate onDownloadFinish isSuccess: " + isSuccess + " code: " + code);
            WinkQZoneTemplateLibJumpHelper.this.g();
        }

        @Override // com.tencent.mobileqq.wink.templatelibrary.jump.a
        public void c(int code) {
            w53.b.f("WinkQZoneTemplateLibJumpHelper", "jumpVideoTemplate onJumpError code: " + code);
            WinkQZoneTemplateLibJumpHelper.this.g();
        }

        @Override // com.tencent.mobileqq.wink.templatelibrary.jump.a
        public void onDownloadStart() {
            w53.b.f("WinkQZoneTemplateLibJumpHelper", "jumpVideoTemplate onDownloadStart");
            WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper = WinkQZoneTemplateLibJumpHelper.this;
            Context context = this.f326228b;
            MetaMaterial metaMaterial = winkQZoneTemplateLibJumpHelper.selectedTemplate;
            Intrinsics.checkNotNull(metaMaterial);
            winkQZoneTemplateLibJumpHelper.u(context, metaMaterial);
        }

        @Override // com.tencent.mobileqq.wink.templatelibrary.jump.a
        public void onProgressUpdate(int delta) {
        }
    }
}
