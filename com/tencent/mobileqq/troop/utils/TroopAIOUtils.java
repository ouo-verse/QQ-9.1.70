package com.tencent.mobileqq.troop.utils;

import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqnt.aio.api.IAIOBlurApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0004JB\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/utils/TroopAIOUtils;", "", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "c", "", "content", "Lcom/tencent/mvi/base/route/j;", "messenger", "showKeyboard", "", "b", "troopUin", "atUin", "logTag", "errorToastText", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopAIOUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TroopAIOUtils f301862a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62040);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f301862a = new TroopAIOUtils();
        }
    }

    TroopAIOUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String content, @NotNull final String troopUin, @NotNull final String atUin, @NotNull final String logTag, @NotNull final com.tencent.mvi.base.route.j messenger, final boolean showKeyboard, @NotNull final String errorToastText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, content, troopUin, atUin, logTag, messenger, Boolean.valueOf(showKeyboard), errorToastText);
            return;
        }
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(atUin, "atUin");
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        Intrinsics.checkNotNullParameter(errorToastText, "errorToastText");
        final QQText qQText = ((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(content, 32);
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(troopUin, atUin, logTag, new Function1<TroopMemberNickInfo, Unit>(logTag, troopUin, atUin, errorToastText, messenger, showKeyboard, qQText) { // from class: com.tencent.mobileqq.troop.utils.TroopAIOUtils$fillAtSomeoneMessageToInputArea$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $atUin;
            final /* synthetic */ String $errorToastText;
            final /* synthetic */ String $logTag;
            final /* synthetic */ com.tencent.mvi.base.route.j $messenger;
            final /* synthetic */ QQText $qqTextContent;
            final /* synthetic */ boolean $showKeyboard;
            final /* synthetic */ String $troopUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$logTag = logTag;
                this.$troopUin = troopUin;
                this.$atUin = atUin;
                this.$errorToastText = errorToastText;
                this.$messenger = messenger;
                this.$showKeyboard = showKeyboard;
                this.$qqTextContent = qQText;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, logTag, troopUin, atUin, errorToastText, messenger, Boolean.valueOf(showKeyboard), qQText);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopMemberNickInfo troopMemberNickInfo) {
                invoke2(troopMemberNickInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable TroopMemberNickInfo troopMemberNickInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopMemberNickInfo);
                    return;
                }
                String showName = troopMemberNickInfo != null ? troopMemberNickInfo.getShowName() : null;
                if (showName == null || showName.length() == 0) {
                    com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.d(this.$logTag, "fillAtSomeoneMessageToInputArea fail got " + showName + ", troopUin = " + this.$troopUin + " atUin = " + this.$atUin);
                    if (this.$errorToastText.length() > 0) {
                        QQToastUtil.showQQToastInUiThread(1, this.$errorToastText);
                        return;
                    }
                    return;
                }
                String uid = troopMemberNickInfo.getUid();
                if (uid.length() == 0) {
                    com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.d(this.$logTag, "fillAtSomeoneMessageToInputArea fail got " + showName + ", troopUin = " + this.$troopUin + " atUin = " + this.$atUin);
                    if (this.$errorToastText.length() > 0) {
                        QQToastUtil.showQQToastInUiThread(1, this.$errorToastText);
                        return;
                    }
                    return;
                }
                this.$messenger.h(InputEditTextMsgIntent.ClearEditTextContent.f189408d);
                this.$messenger.h(new InputAtMsgIntent.InsertAtMemberSpan(uid, this.$atUin, showName, this.$showKeyboard));
                com.tencent.mvi.base.route.j jVar = this.$messenger;
                String qQText2 = this.$qqTextContent.toString();
                Intrinsics.checkNotNullExpressionValue(qQText2, "qqTextContent.toString()");
                jVar.h(new InputEditTextMsgIntent.AppendTextToEditText(qQText2, false, 2, null));
            }
        });
    }

    public final void b(@NotNull String content, @NotNull com.tencent.mvi.base.route.j messenger, boolean showKeyboard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, content, messenger, Boolean.valueOf(showKeyboard));
            return;
        }
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        QQText qQText = ((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(content, 32);
        messenger.h(InputEditTextMsgIntent.ClearEditTextContent.f189408d);
        String qQText2 = qQText.toString();
        Intrinsics.checkNotNullExpressionValue(qQText2, "qqTextContent.toString()");
        messenger.h(new InputEditTextMsgIntent.AppendTextToEditText(qQText2, showKeyboard));
    }

    public final boolean c(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        Integer num;
        String str;
        boolean z16;
        AIOSession r16;
        AIOContact c16;
        AIOSession r17;
        AIOContact c17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioContext)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        AIOParam g16 = aioContext.g();
        Long l3 = null;
        if (g16 != null && (r17 = g16.r()) != null && (c17 = r17.c()) != null) {
            num = Integer.valueOf(c17.e());
        } else {
            num = null;
        }
        AIOParam g17 = aioContext.g();
        if (g17 != null && (r16 = g17.r()) != null && (c16 = r16.c()) != null) {
            str = c16.j();
        } else {
            str = null;
        }
        AIOParam g18 = aioContext.g();
        if (g18 != null) {
            l3 = Long.valueOf(su3.c.a(g18));
        }
        if (!com.tencent.mobileqq.aio.a.d(aioContext) && !com.tencent.mobileqq.aio.a.c(aioContext)) {
            z16 = true;
        } else {
            z16 = false;
        }
        return ((IAIOBlurApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOBlurApi.class)).enableBlur(new com.tencent.qqnt.aio.data.b(num, str, l3, z16));
    }
}
