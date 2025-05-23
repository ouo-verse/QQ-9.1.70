package com.tencent.qqnt.biz.lightbusiness.lightinteraction;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.LIAActionItem;
import com.tencent.qqnt.kernel.nativeinterface.LiteActionAttr;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J,\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJk\u0010$\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00152K\u0010#\u001aG\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00040\u001dJ&\u0010(\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nJg\u0010+\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010&\u001a\u00020%2G\u0010*\u001aC\u0012\u0013\u0012\u00110%\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(&\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012\u0012\u0004\u0012\u00020\u00040)J\u001e\u0010.\u001a\u0004\u0018\u00010\r2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010,J\u001a\u00100\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u001a2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAHelper;", "", "Ljava/lang/Runnable;", "runnable", "", tl.h.F, "", "uid", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/b;", "res", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/d;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/a;", "ext", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "Lkotlin/collections/HashMap;", "f", "allowScene", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAScene;", "checkScene", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/LIAActionItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "scene", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isSuc", "sucCount", "totalCount", "doneCallback", "j", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "randomInt", "g", "Lkotlin/Function2;", "callback", "k", "", "msgAttrs", "r", "other", "l", "<init>", "()V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class LIAHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LIAHelper f353124a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29749);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f353124a = new LIAHelper();
        }
    }

    LIAHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final HashMap<Integer, MsgAttributeInfo> f(com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.a ext) {
        MsgAttributeInfo a16;
        a16 = com.tencent.qqnt.kernel.util.a.f359256a.a(20, (i16 & 2) != 0 ? 0L : 0L, (i16 & 4) != 0 ? null : null, (i16 & 8) != 0 ? null : null, (i16 & 16) != 0 ? null : null, (i16 & 32) != 0 ? null : null, (i16 & 64) != 0 ? null : null, (i16 & 128) != 0 ? null : null, (i16 & 256) != 0 ? null : null, (i16 & 512) != 0 ? null : null, (i16 & 1024) != 0 ? null : null, (i16 & 2048) != 0 ? null : null, (i16 & 4096) != 0 ? null : null, (i16 & 8192) != 0 ? null : null, (i16 & 16384) != 0 ? null : null, (i16 & 32768) != 0 ? null : null, (i16 & 65536) != 0 ? null : null, (i16 & 131072) != 0 ? null : null, (i16 & 262144) != 0 ? null : null);
        LiteActionAttr liteActionAttr = new LiteActionAttr();
        liteActionAttr.type = ext.c();
        liteActionAttr.subType = ext.b();
        liteActionAttr.objectType = ext.a();
        a16.liteAction = liteActionAttr;
        HashMap<Integer, MsgAttributeInfo> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf(a16.attrType), a16);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(final Runnable runnable) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.i
                @Override // java.lang.Runnable
                public final void run() {
                    LIAHelper.i(runnable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(String uid, final com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b res, final d listener) {
        boolean z16;
        String p16 = p(res);
        boolean z17 = false;
        if (p16 != null && p16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("LIAHelper", 2, "[getUrlAndDownload] fail. no valid icon for type=" + res.n() + ", subType=" + res.m());
            }
            listener.onFail();
            return;
        }
        final URLDrawable drawable = URLDrawable.getDrawable(p16, URLDrawable.URLDrawableOptions.obtain());
        File fileInLocal = drawable.getFileInLocal();
        if (fileInLocal != null && fileInLocal.isFile() && fileInLocal.exists()) {
            z17 = true;
        }
        QLog.d("LIAHelper", 1, "[getUrlAndDownload] fileInLocal = " + z17);
        if (z17) {
            h(new Runnable() { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.j
                @Override // java.lang.Runnable
                public final void run() {
                    LIAHelper.n(d.this, drawable, res);
                }
            });
        } else {
            drawable.downloadImediatly(true);
            h(new Runnable() { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.k
                @Override // java.lang.Runnable
                public final void run() {
                    LIAHelper.o(d.this, drawable, res);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(d listener, URLDrawable drawable, com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b res) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(res, "$res");
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        listener.a(drawable, res);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(d listener, URLDrawable drawable, com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b res) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(res, "$res");
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        listener.a(drawable, res);
    }

    public final void g(@NotNull Contact contact, @NotNull LIAActionItem item, int randomInt, @NotNull d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, contact, item, Integer.valueOf(randomInt), listener);
            return;
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (QLog.isDevelopLevel()) {
            QLog.d("LIAHelper", 1, "[checkAndDownloadForMsgList] uid=" + contact.peerUid + ", type=" + item);
        }
        LIAConfigManager.INSTANCE.a().k(new LIAHelper$checkAndDownloadForMsgList$1(item, contact, listener));
    }

    public final void j(@NotNull String uid, @NotNull LIAActionItem item, @NotNull LIAScene scene, @NotNull Function3<? super Boolean, ? super Integer, ? super Integer, Unit> doneCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uid, item, scene, doneCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(doneCallback, "doneCallback");
        if (QLog.isDevelopLevel()) {
            QLog.d("LIAHelper", 1, "[checkPreloadForScene] uid=" + uid + ", type=" + item + ", scene=" + scene);
        }
        LIAConfigManager.INSTANCE.a().k(new LIAHelper$checkPreloadForScene$1(item, scene, doneCallback, uid));
    }

    public final void k(@NotNull LIAActionItem item, @NotNull com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b res, @NotNull Contact contact, @NotNull Function2<? super Contact, ? super HashMap<Integer, MsgAttributeInfo>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, item, res, contact, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (res.d().length() != 0) {
            z16 = false;
        }
        if (z16 && res.i() <= 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d("LIAHelper", 4, "[checkReplyAndBuildExt] no need to set ext");
            }
            callback.invoke(contact, null);
        } else {
            com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.a aVar = new com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.a();
            aVar.f(res.n());
            aVar.e(res.m());
            aVar.d(item.b());
            Unit unit = Unit.INSTANCE;
            callback.invoke(contact, f(aVar));
        }
    }

    @NotNull
    public final LIAActionItem l(@NotNull LIAActionItem other, @Nullable com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b res) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LIAActionItem) iPatchRedirector.redirect((short) 8, (Object) this, (Object) other, (Object) res);
        }
        Intrinsics.checkNotNullParameter(other, "other");
        if (res == null) {
            return other;
        }
        LIAActionItem lIAActionItem = new LIAActionItem();
        lIAActionItem.o(other.getType());
        lIAActionItem.j(other.b());
        lIAActionItem.g(other.a());
        lIAActionItem.m(res.g());
        lIAActionItem.l(other.e());
        if (TextUtils.isEmpty(lIAActionItem.e())) {
            lIAActionItem.l(res.a());
        }
        lIAActionItem.g(res.b());
        lIAActionItem.k(res.m());
        return lIAActionItem;
    }

    @Nullable
    public final String p(@Nullable com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b res) {
        String f16;
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) res);
        }
        if (res == null || (f16 = res.f()) == null) {
            return null;
        }
        boolean z16 = false;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(f16, "/", false, 2, null);
        if (startsWith$default) {
            String e16 = res.e();
            if (e16.length() == 0) {
                z16 = true;
            }
            if (z16) {
                e16 = "https://static-res.qq.com/static-res";
            }
            return ((Object) e16) + f16;
        }
        return f16;
    }

    public final boolean q(int allowScene, @NotNull LIAScene checkScene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, allowScene, (Object) checkScene)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(checkScene, "checkScene");
        if ((allowScene & checkScene.getKey()) == checkScene.getKey()) {
            return true;
        }
        return false;
    }

    @Nullable
    public final com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.a r(@Nullable Map<Integer, MsgAttributeInfo> msgAttrs) {
        boolean z16;
        MsgAttributeInfo msgAttributeInfo;
        LiteActionAttr liteActionAttr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) msgAttrs);
        }
        if (msgAttrs != null && !msgAttrs.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || (msgAttributeInfo = msgAttrs.get(20)) == null || (liteActionAttr = msgAttributeInfo.liteAction) == null) {
            return null;
        }
        return LIAParseUtil.f353136a.a(liteActionAttr);
    }
}
