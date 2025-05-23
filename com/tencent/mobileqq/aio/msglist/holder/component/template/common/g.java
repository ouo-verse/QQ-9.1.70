package com.tencent.mobileqq.aio.msglist.holder.component.template.common;

import com.tencent.mobileqq.ark.config.ArkMsgReplyConfigMgr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/g;", "", "", "", "b", "Ljava/util/List;", "a", "()Ljava/util/List;", "EMOJI_REPLY_SUPPORT_APPS", "", "c", "getSUPPORT_FAV_APP_NAMES", "SUPPORT_FAV_APP_NAMES", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f191921a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> EMOJI_REPLY_SUPPORT_APPS;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> SUPPORT_FAV_APP_NAMES;

    static {
        List<String> listOf;
        List<String> mutableListOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63375);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f191921a = new g();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"com.tencent.tuwen.lua", "com.tencent.contact.lua", "com.tencent.music.lua", "com.tencent.miniapp.lua", "com.tencent.multimsg", "com.tencent.map", "com.tencent.gameinvite.lua", "com.tencent.video.lua", "com.tencent.picture.lua", "com.tencent.activity.lua", "com.tencent.structmsg", "com.tencent.mannounce", "com.tencent.miniapp", "com.tencent.tdoc.qqpush", "com.tencent.miniapp_01", "com.tencent.groupphoto", "com.tencent.gamecenter.gameshare", ArkMsgReplyConfigMgr.ARK_REPLY_FROM_TYPE_CARD_ARK_APP, "com.tencent.qzone.albumShare", "com.tencent.gamecenter.gameshare_sgame", "com.tencent.gamecenter.sgamebattle", "com.tencent.qq.checkin", "com.tencent.qzone.albumInvite", "com.tencent.troopsharecard", "com.tencent.creategroupmsg", "com.tencent.qqlover.inviteark", "com.tencent.qun.invite", "com.tencent.qq.signin", "com.tencent.qbox.simpleshare", "com.tencent.template.qqfavorite.share"});
        EMOJI_REPLY_SUPPORT_APPS = listOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("com.tencent.map", "com.tencent.structmsg", "com.tencent.miniapp_01", ArkMsgReplyConfigMgr.ARK_REPLY_FROM_TYPE_CARD_ARK_APP);
        SUPPORT_FAV_APP_NAMES = mutableListOf;
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final List<String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return EMOJI_REPLY_SUPPORT_APPS;
    }
}
