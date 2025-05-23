package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/app/parser/bh;", "Lcom/tencent/mobileqq/utils/ax;", "", "b", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/content/Context;", "cc", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class bh extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/app/parser/bh$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.parser.bh$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54648);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public bh(@Nullable QQAppInterface qQAppInterface, @Nullable Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r3);
     */
    @Override // com.tencent.mobileqq.utils.ax
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b() {
        Long l3;
        int i3;
        Integer intOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("NearbyProOpenPageAction", 2, "doAction , thread:" + Thread.currentThread().getName());
        }
        try {
            if (Intrinsics.areEqual("feed_publish", this.f307440e)) {
                String str = this.f307441f.get("source");
                if (str != null && intOrNull != null) {
                    i3 = intOrNull.intValue();
                } else {
                    i3 = -1;
                }
                String str2 = this.f307441f.get("topicIds");
                if (str2 == null) {
                    str2 = "";
                }
                INearbyProPageRouter iNearbyProPageRouter = (INearbyProPageRouter) QRoute.api(INearbyProPageRouter.class);
                Context context = this.f307437b;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                iNearbyProPageRouter.launchNearbyFeedPublishFragment(context, i3, str2);
            } else {
                if (!Intrinsics.areEqual("feed_detail", this.f307440e)) {
                    return false;
                }
                String str3 = this.f307441f.get("feedID");
                String str4 = this.f307441f.get("tinyID");
                String str5 = this.f307441f.get("name");
                String str6 = this.f307441f.get(PhotoCategorySummaryInfo.AVATAR_URL);
                String str7 = this.f307441f.get("avatarDressBorderUrl");
                INearbyProPageRouter iNearbyProPageRouter2 = (INearbyProPageRouter) QRoute.api(INearbyProPageRouter.class);
                Context context2 = this.f307437b;
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                if (str4 != null) {
                    l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(str4);
                } else {
                    l3 = null;
                }
                iNearbyProPageRouter2.launchNearbyFeedDetailFragment(context2, str3, l3, str5, str6, str7, null, 2);
            }
            return true;
        } catch (Exception e16) {
            QLog.e("NearbyProOpenPageAction", 1, "doAction error: " + e16.getMessage());
            i("NearbyProOpenPageAction");
            return false;
        }
    }
}
