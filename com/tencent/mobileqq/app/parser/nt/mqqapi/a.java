package com.tencent.mobileqq.app.parser.nt.mqqapi;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.relation.nt.mqqapi.RelationOpenPageAction;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ0\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/app/parser/nt/mqqapi/a;", "Lcom/tencent/mobileqq/app/parser/av;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "", "jump", "Lcom/tencent/mobileqq/app/parser/JumpParserResult;", "jumpParserResult", "Lcom/tencent/mobileqq/utils/ax;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a extends av {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/app/parser/nt/mqqapi/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.parser.nt.mqqapi.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54680);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.av
    @NotNull
    public ax a(@Nullable BaseQQAppInterface app, @Nullable Context context, @Nullable String jump, @Nullable JumpParserResult jumpParserResult) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        boolean contains$default5;
        boolean contains$default6;
        boolean contains$default7;
        boolean contains$default8;
        boolean contains$default9;
        boolean contains$default10;
        List split$default;
        List split$default2;
        List split;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ax) iPatchRedirector.redirect((short) 2, this, app, context, jump, jumpParserResult);
        }
        if (QLog.isColorLevel()) {
            QLog.d("RelationOpenPageParser", 2, "parse\uff1a" + jump);
        }
        RelationOpenPageAction relationOpenPageAction = new RelationOpenPageAction((QQAppInterface) app, context);
        relationOpenPageAction.f307438c = jump;
        relationOpenPageAction.f307439d = "relation";
        if (jump != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) jump, (CharSequence) "deleteFriends", false, 2, (Object) null);
            if (contains$default) {
                relationOpenPageAction.f307440e = "deleteFriends";
            }
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) jump, (CharSequence) "welcome", false, 2, (Object) null);
            if (contains$default2) {
                relationOpenPageAction.f307440e = "welcome";
            }
            contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) jump, (CharSequence) AppConstants.Preferences.TROOP_NICK, false, 2, (Object) null);
            if (contains$default3) {
                relationOpenPageAction.f307440e = AppConstants.Preferences.TROOP_NICK;
            }
            contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) jump, (CharSequence) "modifyGroupName", false, 2, (Object) null);
            if (contains$default4) {
                relationOpenPageAction.f307440e = "modifyGroupName";
            }
            contains$default5 = StringsKt__StringsKt.contains$default((CharSequence) jump, (CharSequence) "tempManager", false, 2, (Object) null);
            if (contains$default5) {
                relationOpenPageAction.f307440e = "tempManager";
            }
            contains$default6 = StringsKt__StringsKt.contains$default((CharSequence) jump, (CharSequence) "friendSetting", false, 2, (Object) null);
            if (contains$default6) {
                relationOpenPageAction.f307440e = "friendSetting";
            }
            contains$default7 = StringsKt__StringsKt.contains$default((CharSequence) jump, (CharSequence) QQFriendJsPlugin.API_ADD_FRIEND, false, 2, (Object) null);
            if (contains$default7) {
                relationOpenPageAction.f307440e = QQFriendJsPlugin.API_ADD_FRIEND;
            }
            contains$default8 = StringsKt__StringsKt.contains$default((CharSequence) jump, (CharSequence) "intimateInfo", false, 2, (Object) null);
            if (contains$default8) {
                relationOpenPageAction.f307440e = "intimateInfo";
            }
            contains$default9 = StringsKt__StringsKt.contains$default((CharSequence) jump, (CharSequence) "partner_signin", false, 2, (Object) null);
            if (contains$default9) {
                relationOpenPageAction.f307440e = "partner_signin";
            }
            contains$default10 = StringsKt__StringsKt.contains$default((CharSequence) jump, (CharSequence) "visitorLike", false, 2, (Object) null);
            if (contains$default10) {
                relationOpenPageAction.f307440e = "visitorLike";
            }
            split$default = StringsKt__StringsKt.split$default((CharSequence) jump, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
            Object[] array = split$default.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            if (strArr.length == 2) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) strArr[1], new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
                Object[] array2 = split$default2.toArray(new String[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr2 = (String[]) array2;
                if (strArr2 != null) {
                    for (String str : strArr2) {
                        split = StringsKt__StringsKt.split((CharSequence) str, new char[]{'='}, false, 2);
                        Object[] array3 = split.toArray(new String[0]);
                        Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        String[] strArr3 = (String[]) array3;
                        if (strArr3 != null && strArr3.length == 2) {
                            relationOpenPageAction.r(strArr3[0], strArr3[1]);
                        }
                    }
                }
                return relationOpenPageAction;
            }
            return relationOpenPageAction;
        }
        return relationOpenPageAction;
    }
}
