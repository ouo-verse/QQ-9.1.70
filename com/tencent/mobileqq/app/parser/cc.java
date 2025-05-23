package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi;
import com.tencent.mobileqq.gamecenter.api.IGameShareLinkReporter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IQQSearchApi;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B/\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/app/parser/cc;", "Lcom/tencent/mobileqq/utils/ax;", "Landroid/content/Context;", "ctx", "", "action", "url", "", UserInfo.SEX_FEMALE, "", "b", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", ZPlanPublishSource.FROM_SCHEME, "Lcom/tencent/mobileqq/app/parser/JumpParserResult;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/app/parser/JumpParserResult;", "jumpParserResult", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "cc", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mobileqq/app/parser/JumpParserResult;)V", ExifInterface.LATITUDE_SOUTH, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class cc extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private final String scheme;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private final JumpParserResult jumpParserResult;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/app/parser/cc$a;", "", "", "ACTION_OPEN", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.parser.cc$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54668);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public cc(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context, @Nullable String str, @Nullable JumpParserResult jumpParserResult) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, baseQQAppInterface, context, str, jumpParserResult);
        } else {
            this.scheme = str;
            this.jumpParserResult = jumpParserResult;
        }
    }

    private final void F(Context ctx, String action, String url) {
        boolean contains$default;
        boolean contains$default2;
        if (Intrinsics.areEqual(action, "open")) {
            String queryParameter = Uri.parse(url).getQueryParameter("page_name");
            if (queryParameter != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) queryParameter, (CharSequence) "GameCenter", false, 2, (Object) null);
                if (!contains$default) {
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) queryParameter, (CharSequence) "qsearch_detail", false, 2, (Object) null);
                    if (contains$default2 && ((IQQSearchApi) QRoute.api(IQQSearchApi.class)).useNativeNetSearchPage()) {
                        ((IQQSearchApi) QRoute.api(IQQSearchApi.class)).jump2NetSearchPage(ctx, url);
                        return;
                    }
                } else {
                    ((IGameShareLinkReporter) QRoute.api(IGameShareLinkReporter.class)).reportGameShareLink(url);
                    ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).reportIfNeed(url);
                }
            }
            ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).jump(ctx, url);
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        Context context = this.f307437b;
        if (context == null || (str = this.scheme) == null) {
            return true;
        }
        JumpParserResult jumpParserResult = this.jumpParserResult;
        if (jumpParserResult != null) {
            str2 = jumpParserResult.getAction();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            return true;
        }
        F(context, str2, str);
        return true;
    }
}
