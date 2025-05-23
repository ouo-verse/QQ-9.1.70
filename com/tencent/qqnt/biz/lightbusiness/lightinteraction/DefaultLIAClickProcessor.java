package com.tencent.qqnt.biz.lightbusiness.lightinteraction;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.gson.internal.LinkedTreeMap;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOEmoApi;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAInjectUtil;
import com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JY\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022G\u0010\u0018\u001aC\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0017\u0012\u0004\u0012\u00020\f0\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/DefaultLIAClickProcessor;", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/c;", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAInjectUtil$a;", "extraInfo", "", "f", "Lcom/google/gson/internal/LinkedTreeMap;", "", "", "g", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAScene;", "scene", "", "i", "k", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", tl.h.F, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "contact", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "Lkotlin/collections/HashMap;", "afterPreAction", "d", "j", "l", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Landroid/view/View;", "view", "", "a", "<init>", "()V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class DefaultLIAClickProcessor implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/DefaultLIAClickProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.biz.lightbusiness.lightinteraction.DefaultLIAClickProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29695);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public DefaultLIAClickProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d(final LIAInjectUtil.a extraInfo, final Function2<? super Contact, ? super HashMap<Integer, MsgAttributeInfo>, Unit> afterPreAction) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.a
            @Override // java.lang.Runnable
            public final void run() {
                DefaultLIAClickProcessor.e(DefaultLIAClickProcessor.this, extraInfo, afterPreAction);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(DefaultLIAClickProcessor this$0, LIAInjectUtil.a extraInfo, Function2 afterPreAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(extraInfo, "$extraInfo");
        Intrinsics.checkNotNullParameter(afterPreAction, "$afterPreAction");
        Contact h16 = this$0.h(extraInfo);
        if (h16 != null) {
            if (extraInfo.c()) {
                LIAHelper.f353124a.k(extraInfo.d(), extraInfo.e(), h16, afterPreAction);
            } else {
                afterPreAction.invoke(h16, null);
            }
        }
    }

    private final int f(LIAInjectUtil.a extraInfo) {
        if (extraInfo.c()) {
            return extraInfo.e().b();
        }
        return extraInfo.e().i();
    }

    private final LinkedTreeMap<String, Object> g(LIAInjectUtil.a extraInfo) {
        if (extraInfo.c()) {
            return extraInfo.e().h();
        }
        return extraInfo.e().j();
    }

    private final Contact h(LIAInjectUtil.a extraInfo) {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        Contact b16 = extraInfo.b();
        if (b16 == null) {
            com.tencent.aio.api.runtime.a a16 = extraInfo.a();
            if (a16 != null && (g16 = a16.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
                return new Contact(c16.e(), c16.j(), c16.f());
            }
            return null;
        }
        return b16;
    }

    private final void i(LIAScene scene, LIAInjectUtil.a extraInfo) {
        switch (f(extraInfo)) {
            case 100:
                m(extraInfo);
                return;
            case 101:
                n(extraInfo);
                return;
            case 102:
                l(extraInfo);
                return;
            case 103:
                j(extraInfo);
                return;
            case 104:
                k(extraInfo);
                return;
            default:
                return;
        }
    }

    private final void j(LIAInjectUtil.a extraInfo) {
        Object obj;
        com.tencent.aio.api.runtime.a a16;
        com.tencent.mvi.base.route.j e16;
        if (extraInfo.a() != null) {
            LinkedTreeMap<String, Object> g16 = g(extraInfo);
            String str = null;
            if (g16 != null) {
                obj = g16.get("keyword");
            } else {
                obj = null;
            }
            if (obj instanceof String) {
                str = (String) obj;
            }
            if (str != null && (a16 = extraInfo.a()) != null && (e16 = a16.e()) != null) {
                e16.h(new StickerRecommendEvent.TriggerShowEmotionKeywordLayout(str, true));
            }
        }
    }

    private final void k(LIAInjectUtil.a extraInfo) {
        Context context;
        Object obj;
        Fragment c16;
        com.tencent.aio.api.runtime.a a16 = extraInfo.a();
        if (a16 == null || (c16 = a16.c()) == null || (context = c16.getContext()) == null) {
            context = BaseApplication.context;
        }
        LinkedTreeMap<String, Object> g16 = g(extraInfo);
        String str = null;
        if (g16 != null) {
            obj = g16.get("weburl");
        } else {
            obj = null;
        }
        if (obj instanceof String) {
            str = (String) obj;
        }
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d("DefaultLIAClickProcessor", 1, "[handleOpenWebView] fail, webUrl is not valid.");
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("DefaultLIAClickProcessor", 1, "[handleOpenWebView] do webUrl=" + str);
        }
        Intent intent = new Intent();
        intent.putExtra("url", str);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    private final void l(LIAInjectUtil.a extraInfo) {
        Object obj;
        String str;
        LinkedTreeMap<String, Object> g16 = g(extraInfo);
        BaseQQAppInterface baseQQAppInterface = null;
        if (g16 != null) {
            obj = g16.get("url_scheme");
        } else {
            obj = null;
        }
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d("DefaultLIAClickProcessor", 1, "[handleSchemaJump] fail, url is not valid.");
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("DefaultLIAClickProcessor", 1, "[handleSchemaJump] do schema url=" + str);
        }
        com.tencent.qqnt.biz.lightbusiness.lightinteraction.scheme.a aVar = com.tencent.qqnt.biz.lightbusiness.lightinteraction.scheme.a.f353170a;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        }
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        boolean a16 = aVar.a(baseQQAppInterface, context, str);
        if (QLog.isColorLevel()) {
            QLog.d("DefaultLIAClickProcessor", 1, "[handleSchemaJump] do schema jump url=" + str + ", result: " + a16);
        }
    }

    private final void m(final LIAInjectUtil.a extraInfo) {
        Object obj;
        int i3;
        final Ref.IntRef intRef = new Ref.IntRef();
        LinkedTreeMap<String, Object> h16 = extraInfo.e().h();
        Double d16 = null;
        if (h16 != null) {
            obj = h16.get("emotion_id");
        } else {
            obj = null;
        }
        if (obj instanceof Double) {
            d16 = (Double) obj;
        }
        if (d16 != null) {
            i3 = (int) d16.doubleValue();
        } else {
            i3 = 0;
        }
        intRef.element = i3;
        if (i3 == 0) {
            intRef.element = LIAConfigManager.INSTANCE.a().h(extraInfo.e().n());
        }
        d(extraInfo, new Function2<Contact, HashMap<Integer, MsgAttributeInfo>, Unit>(extraInfo, intRef) { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.DefaultLIAClickProcessor$handleSendEmotionMsg$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ LIAInjectUtil.a $extraInfo;
            final /* synthetic */ Ref.IntRef $id;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$extraInfo = extraInfo;
                this.$id = intRef;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, DefaultLIAClickProcessor.this, extraInfo, intRef);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Contact contact, HashMap<Integer, MsgAttributeInfo> hashMap) {
                invoke2(contact, hashMap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Contact contact, @Nullable HashMap<Integer, MsgAttributeInfo> hashMap) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) contact, (Object) hashMap);
                    return;
                }
                Intrinsics.checkNotNullParameter(contact, "contact");
                DefaultLIAClickProcessor.this.o(this.$extraInfo);
                ((IAIOEmoApi) QRoute.api(IAIOEmoApi.class)).sendEmoMsgFromOther(this.$id.element, contact, true, hashMap);
            }
        });
    }

    private final void n(final LIAInjectUtil.a extraInfo) {
        Object obj;
        boolean z16;
        LinkedTreeMap<String, Object> g16 = g(extraInfo);
        final String str = null;
        if (g16 != null) {
            obj = g16.get("emotion_tips");
        } else {
            obj = null;
        }
        if (obj instanceof String) {
            str = (String) obj;
        }
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = extraInfo.d().getTitle();
        }
        d(extraInfo, new Function2<Contact, HashMap<Integer, MsgAttributeInfo>, Unit>(extraInfo, str) { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.DefaultLIAClickProcessor$handleSendRandomEmo$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ LIAInjectUtil.a $extraInfo;
            final /* synthetic */ String $key;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$extraInfo = extraInfo;
                this.$key = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, DefaultLIAClickProcessor.this, extraInfo, str);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Contact contact, HashMap<Integer, MsgAttributeInfo> hashMap) {
                invoke2(contact, hashMap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Contact contact, @Nullable HashMap<Integer, MsgAttributeInfo> hashMap) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) contact, (Object) hashMap);
                    return;
                }
                Intrinsics.checkNotNullParameter(contact, "contact");
                DefaultLIAClickProcessor.this.o(this.$extraInfo);
                ((IAIOEmoApi) QRoute.api(IAIOEmoApi.class)).sendRandomPicEmotionMsgFromOther(this.$key, contact, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(LIAInjectUtil.a extraInfo) {
        boolean z16;
        if (!extraInfo.c()) {
            return;
        }
        String l3 = extraInfo.e().l();
        Contact h16 = h(extraInfo);
        if (l3.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && h16 != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("DefaultLIAClickProcessor", 4, "sendLocalGrayTipBefore: msg=" + l3 + ", uid=" + h16.peerUid);
            }
            QLog.d("DefaultLIAClickProcessor", 1, "sendLocalGrayTipBeforeAfter: msg=" + l3 + ", uid=" + h16.peerUid);
            String a16 = com.tencent.qqnt.biz.lightbusiness.lightinteraction.replace.c.f353167a.a(new com.tencent.qqnt.biz.lightbusiness.lightinteraction.replace.d(h16), l3);
            String str = h16.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "contact.peerUid");
            LocalGrayTip m3 = LocalGrayTip.LocalGrayTipBuilder.i(new LocalGrayTip.LocalGrayTipBuilder(str, h16.chatType, 2041L, 0, true, false, null, 72, null), a16, 0, 2, null).m();
            INtGrayTipApi iNtGrayTipApi = (INtGrayTipApi) QRoute.api(INtGrayTipApi.class);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
            iNtGrayTipApi.addLocalGrayTip(peekAppRuntime, m3, null);
        }
    }

    @Override // com.tencent.qqnt.biz.lightbusiness.lightinteraction.c
    public boolean a(@Nullable View view, @NotNull LIAScene scene, @NotNull LIAInjectUtil.a extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, view, scene, extraInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        if (f(extraInfo) < 100) {
            if (QLog.isDevelopLevel()) {
                QLog.d("DefaultLIAClickProcessor", 1, "[handleClick] invalid. not support mode, handle by business. mode=" + f(extraInfo) + ", type=" + extraInfo.d().getType() + ", subType=" + extraInfo.d().c());
                return false;
            }
            return false;
        }
        i(scene, extraInfo);
        return true;
    }
}
