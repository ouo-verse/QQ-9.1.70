package com.tencent.mobileqq.troop.troopcard.utils;

import android.content.Context;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.schooltoolbox.fragment.SchoolToolboxFragment;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapWithDefaultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u001b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\t\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/utils/a;", "Lcom/tencent/mobileqq/utils/ax;", "", "b", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/HashMap;", UserInfo.SEX_FEMALE, "()Ljava/lang/String;", "group_id", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Req, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends ax {
    static IPatchRedirector $redirector_;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    static final /* synthetic */ KProperty<Object>[] S;

    /* renamed from: Q, reason: from kotlin metadata */
    private final HashMap group_id;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/utils/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.utils.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57430);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            S = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "group_id", "getGroup_id()Ljava/lang/String;", 0))};
            INSTANCE = new Companion(null);
        }
    }

    public a(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
        } else {
            this.group_id = this.f307441f;
        }
    }

    @Nullable
    public final String F() {
        Object orImplicitDefaultNullable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        HashMap hashMap = this.group_id;
        Intrinsics.checkNotNullExpressionValue(hashMap, "<get-group_id>(...)");
        orImplicitDefaultNullable = MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(hashMap, S[0].getName());
        return (String) orImplicitDefaultNullable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r3);
     */
    @Override // com.tencent.mobileqq.utils.ax
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b() {
        long j3;
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        QLog.i("SchoolToolJumpAction", 1, "[doAction] attrs = " + this.f307441f);
        SchoolToolboxFragment.Companion companion = SchoolToolboxFragment.INSTANCE;
        Context context = this.f307437b;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String F = F();
        if (F != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        companion.a(context, j3);
        return true;
    }
}
