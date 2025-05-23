package com.tencent.mobileqq.troop.troopsquare.topic;

import android.content.Context;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopsquare.topic.fragment.TroopSquareTopicFragment;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u001b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R0\u0010\t\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b*\u0004\b\f\u0010\rR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u000b*\u0004\b\u0010\u0010\rR\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u000b*\u0004\b\u0013\u0010\rR\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u000b*\u0004\b\u0016\u0010\r\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/TroopSquareTopicJumpAction;", "Lcom/tencent/mobileqq/utils/ax;", "", "b", "", "", "kotlin.jvm.PlatformType", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/Map;", "attrsOrNull", "G", "()Ljava/lang/String;", "getGroup_id$delegate", "(Lcom/tencent/mobileqq/troop/troopsquare/topic/TroopSquareTopicJumpAction;)Ljava/lang/Object;", "group_id", "H", "getTopic_id$delegate", "topic_id", UserInfo.SEX_FEMALE, "getExg$delegate", "exg", "I", "getTopic_source$delegate", "topic_source", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Req, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSquareTopicJumpAction extends ax {
    static IPatchRedirector $redirector_;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    static final /* synthetic */ KProperty<Object>[] S;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Map<String, String> attrsOrNull;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/TroopSquareTopicJumpAction$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsquare.topic.TroopSquareTopicJumpAction$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61585);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            S = new KProperty[]{Reflection.property1(new PropertyReference1Impl(TroopSquareTopicJumpAction.class, "group_id", "getGroup_id()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(TroopSquareTopicJumpAction.class, "topic_id", "getTopic_id()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(TroopSquareTopicJumpAction.class, "exg", "getExg()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(TroopSquareTopicJumpAction.class, "topic_source", "getTopic_source()Ljava/lang/String;", 0))};
            INSTANCE = new Companion(null);
        }
    }

    public TroopSquareTopicJumpAction(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context) {
        super(baseQQAppInterface, context);
        Map<String, String> withDefaultMutable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
            return;
        }
        HashMap<String, String> attrs = this.f307441f;
        Intrinsics.checkNotNullExpressionValue(attrs, "attrs");
        withDefaultMutable = MapsKt__MapWithDefaultKt.withDefaultMutable(attrs, TroopSquareTopicJumpAction$attrsOrNull$1.INSTANCE);
        this.attrsOrNull = withDefaultMutable;
    }

    private final String F() {
        Object orImplicitDefaultNullable;
        orImplicitDefaultNullable = MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(this.attrsOrNull, S[2].getName());
        return (String) orImplicitDefaultNullable;
    }

    private final String G() {
        Object orImplicitDefaultNullable;
        orImplicitDefaultNullable = MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(this.attrsOrNull, S[0].getName());
        return (String) orImplicitDefaultNullable;
    }

    private final String H() {
        Object orImplicitDefaultNullable;
        orImplicitDefaultNullable = MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(this.attrsOrNull, S[1].getName());
        return (String) orImplicitDefaultNullable;
    }

    private final String I() {
        Object orImplicitDefaultNullable;
        orImplicitDefaultNullable = MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(this.attrsOrNull, S[3].getName());
        return (String) orImplicitDefaultNullable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    @Override // com.tencent.mobileqq.utils.ax
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b() {
        long j3;
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        QLog.i("TroopSquare.Topic.TroopSquareTopicJumpAction", 1, "doAction attrs=" + this.f307441f);
        TroopSquareTopicFragment.Companion companion = TroopSquareTopicFragment.INSTANCE;
        String G = G();
        if (G == null) {
            G = "0";
        }
        String str = G;
        String H = H();
        if (H != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        companion.a(str, j3, null, F(), I());
        return true;
    }
}
