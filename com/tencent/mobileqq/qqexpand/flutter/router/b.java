package com.tencent.mobileqq.qqexpand.flutter.router;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.fling.FlingConstant;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.mobileqq.matchchat.MatchChatSettingFragment;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil;
import com.tencent.mobileqq.qqexpand.fragment.ExpandBirthPickFragment;
import com.tencent.mobileqq.qqexpand.fragment.ExpandPublicFragmentActivity;
import com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment;
import com.tencent.mobileqq.qqexpand.fragment.ExtendFriendVoiceMatchLoadingFragment;
import com.tencent.mobileqq.qqexpand.utils.l;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0019\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ0\u0010\u0013\u001a\u00020\u00062&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0016J@\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00152\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0015H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/flutter/router/b;", "Lcom/tencent/mobileqq/qqexpand/flutter/router/a;", "", "pageName", "Landroid/net/Uri;", "pageUri", "", "f", "d", "e", "g", "", "date", h.F, "(Ljava/lang/Integer;)V", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "map", "c", "a", "", "urlParams", "exts", "b", "<init>", "()V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b extends a {
    private final void d() {
        AppRuntime runtime;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        String account = (application == null || (runtime = application.getRuntime()) == null) ? null : runtime.getAccount();
        if (account == null) {
            account = "";
        }
        if (!TextUtils.isEmpty(account)) {
            BaseApplication baseApplication = BaseApplication.context;
            if (baseApplication != null) {
                Intent intent = new Intent(baseApplication, (Class<?>) QQBrowserActivity.class);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("https://ti.qq.com/v2/anonymous/answer?_wv=16777218&_wwv=129&uin=%s&from=%d", Arrays.copyOf(new Object[]{account, 1}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                intent.putExtra("url", format);
                intent.setFlags(268435456);
                baseApplication.startActivity(intent);
                return;
            }
            return;
        }
        l.f264102a.a().e("ExpandRouter", 1, "jump photo stickynote account is null", null);
    }

    private final void e() {
        AppRuntime runtime;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        String account = (application == null || (runtime = application.getRuntime()) == null) ? null : runtime.getAccount();
        if (account == null) {
            account = "";
        }
        if (!TextUtils.isEmpty(account)) {
            BaseApplication baseApplication = BaseApplication.context;
            if (baseApplication != null) {
                String str = IProfileCardConst.URL_PHOTO_WALL + "&uin=" + account;
                Intent intent = new Intent(baseApplication, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("hide_more_button", true);
                intent.putExtra("hide_operation_bar", true);
                intent.putExtra("url", str);
                intent.setFlags(268435456);
                baseApplication.startActivity(intent);
                return;
            }
            return;
        }
        l.f264102a.a().e("ExpandRouter", 1, "jump photo error account is null", null);
    }

    private final void g() {
        AppRuntime runtime;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        String account = (application == null || (runtime = application.getRuntime()) == null) ? null : runtime.getAccount();
        if (account == null) {
            account = "";
        }
        if (!TextUtils.isEmpty(account)) {
            BaseApplication baseApplication = BaseApplication.context;
            if (baseApplication != null) {
                Intent intent = new Intent(baseApplication, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", com.tencent.mobileqq.profile.PersonalityLabel.a.f259945c);
                intent.putExtra("uin", account);
                intent.putExtra(QQBrowserActivity.BROADCAST_ACTION_KEY, "com.tencent.mobileqq.card.modify_personality_label");
                intent.putExtra("fromProfile", false);
                intent.setFlags(268435456);
                baseApplication.startActivity(intent);
                return;
            }
            return;
        }
        l.f264102a.a().e("ExpandRouter", 1, "jump personal_label error account is null", null);
    }

    private final void h(Integer date) {
        Intent intent = new Intent();
        intent.putExtra("birth_date", date != null ? date.intValue() : 0);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.setFlags(268435456);
        QPublicTransFragmentActivity.start(BaseApplication.context, intent, ExpandBirthPickFragment.class);
    }

    @Override // com.tencent.mobileqq.qqexpand.flutter.router.a
    public String a() {
        return "expand";
    }

    @Override // com.tencent.mobileqq.qqexpand.flutter.router.a
    public void b(Uri pageUri, Map<Object, ? extends Object> urlParams, Map<Object, ? extends Object> exts) {
        Intrinsics.checkNotNullParameter(pageUri, "pageUri");
        String path = pageUri.getPath();
        if (path != null) {
            switch (path.hashCode()) {
                case -675666397:
                    if (path.equals("/edit_profile")) {
                        BaseApplication baseApplication = BaseApplication.context;
                        if (baseApplication != null) {
                            Intent intent = new Intent();
                            intent.setFlags(268435456);
                            intent.putExtra(FlingConstant.FLING_ACTION_KEY, 2);
                            intent.putExtra(FlingConstant.FLING_CODE_KEY, hashCode());
                            QPublicFragmentActivity.b.b(baseApplication, intent, QPublicFragmentActivity.class, ExtendFriendNewEditFragment.class);
                            return;
                        }
                        return;
                    }
                    break;
                case -164884942:
                    if (path.equals("/conversation")) {
                        MatchChatMsgListFragment.vh(BaseApplication.context, 2);
                        return;
                    }
                    break;
                case -89405150:
                    if (path.equals("/voiceMatch")) {
                        c((HashMap) exts);
                        return;
                    }
                    break;
                case 1496760:
                    if (path.equals("/aio")) {
                        Intrinsics.checkNotNull(urlParams, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any?>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any?> }");
                        LimitChatUtil.o(pageUri, (HashMap) urlParams);
                        return;
                    }
                    break;
                case 46679261:
                    if (path.equals(JefsClass.PATH_JUMP)) {
                        f(pageUri.getQueryParameter("page"), pageUri);
                        return;
                    }
                    break;
                case 46749288:
                    if (path.equals("/main")) {
                        ExpandPublicFragmentActivity.launchExtendFriendNewFragment(BaseApplication.context, 4, false, (String) (urlParams != null ? urlParams.get("type") : null));
                        return;
                    }
                    break;
                case 1259844215:
                    if (path.equals("/birth_dialog")) {
                        String queryParameter = pageUri.getQueryParameter("date");
                        h(queryParameter != null ? Integer.valueOf(Integer.parseInt(queryParameter)) : null);
                        return;
                    }
                    break;
            }
        }
        l lVar = l.f264102a;
        if (QLog.isColorLevel()) {
            lVar.a().d("ExpandRouter", 2, "native router " + pageUri + " not support");
        }
    }

    private final void f(String pageName, Uri pageUri) {
        AppRuntime runtime;
        if (pageName != null) {
            switch (pageName.hashCode()) {
                case -2095811475:
                    if (pageName.equals("anonymous")) {
                        d();
                        return;
                    }
                    break;
                case -1173124183:
                    if (pageName.equals("feature_photo")) {
                        e();
                        return;
                    }
                    break;
                case 188064685:
                    if (pageName.equals("msg_list_setting")) {
                        Intent intent = new Intent();
                        intent.setFlags(268435456);
                        BaseApplication baseApplication = BaseApplication.context;
                        if (baseApplication != null) {
                            PublicFragmentActivity.start(baseApplication, intent, MatchChatSettingFragment.class);
                            return;
                        }
                        return;
                    }
                    break;
                case 830494773:
                    if (pageName.equals("personal_label")) {
                        g();
                        return;
                    }
                    break;
                case 1221699540:
                    if (pageName.equals("personal_label_edit")) {
                        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
                        String account = (application == null || (runtime = application.getRuntime()) == null) ? null : runtime.getAccount();
                        if (account == null) {
                            account = "";
                        }
                        if (!TextUtils.isEmpty(account)) {
                            BaseApplication baseApplication2 = BaseApplication.context;
                            if (baseApplication2 != null) {
                                Intent intent2 = new Intent(baseApplication2, (Class<?>) PersonalityLabelGalleryActivity.class);
                                intent2.putExtra("uin", account);
                                intent2.setFlags(268435456);
                                intent2.putExtra(FlingConstant.FLING_ACTION_KEY, 2);
                                intent2.putExtra(FlingConstant.FLING_CODE_KEY, hashCode());
                                baseApplication2.startActivity(intent2);
                                return;
                            }
                            return;
                        }
                        l.f264102a.a().e("ExpandRouter", 1, "jump personal_label_edit error account is null", null);
                        return;
                    }
                    break;
            }
        }
        l lVar = l.f264102a;
        if (QLog.isColorLevel()) {
            lVar.a().d("ExpandRouter", 2, "jump to " + pageName + " not notImplemented");
        }
    }

    private final void c(HashMap<String, Object> map) {
        int i3;
        String str = (String) (map != null ? map.get("gender") : null);
        if (str == null) {
            str = "0";
        }
        try {
            i3 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            i3 = 0;
        }
        Intent intent = new Intent();
        intent.putExtra("intent_sex_key", i3);
        PublicFragmentActivity.b.c(intent, PublicFragmentActivity.class, ExtendFriendVoiceMatchLoadingFragment.class);
    }
}
