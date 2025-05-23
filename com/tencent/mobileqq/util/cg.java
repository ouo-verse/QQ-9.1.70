package com.tencent.mobileqq.util;

import android.text.TextUtils;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopMemberSpecialTitleInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u00178\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/util/cg;", "", "", "uin", "", "c", "Lcom/tencent/mobileqq/richstatus/RichStatus;", "richStatus", "", "b", "Lcom/tencent/aio/api/runtime/a;", "aioContext", tl.h.F, "plainTxt", "f", "e", "", "I", "getRichEffectiveTime", "()I", "setRichEffectiveTime", "(I)V", "richEffectiveTime", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "d", "()Ljava/lang/ref/WeakReference;", "g", "(Ljava/lang/ref/WeakReference;)V", "mAIOContext", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class cg {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final cg f306655a = new cg();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int richEffectiveTime = TroopMemberSpecialTitleInfo.SPECIAL_TITLE_EXPIRE_SOON_TIME;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static WeakReference<com.tencent.aio.api.runtime.a> mAIOContext;

    cg() {
    }

    private final void b(RichStatus richStatus) {
        boolean z16 = true;
        if (mAIOContext == null) {
            QLog.i("RichStatusUtil", 1, "mAIOContext is not isInitialized");
            return;
        }
        if (richStatus == null) {
            com.tencent.aio.api.runtime.a aVar = d().get();
            if (aVar != null) {
                f306655a.f("", aVar);
                return;
            }
            return;
        }
        String plainTxt = richStatus.getPlainText();
        long j3 = richStatus.time;
        long serverTime = NetConnInfoCenter.getServerTime();
        double d16 = 72.0d;
        try {
            byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("qq_relation_personal_label_preview_time", new byte[0]);
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            d16 = new JSONObject(new String(loadRawConfig, UTF_8)).optDouble("c2c_time_interval", 72.0d);
        } catch (UnsupportedOperationException | JSONException unused) {
        }
        richEffectiveTime = ((int) d16) * 60 * 60;
        if (QLog.isColorLevel()) {
            if (serverTime - j3 >= richEffectiveTime) {
                z16 = false;
            }
            QLog.i("RichStatusUtil", 2, "needShowRichSubTitle-> c = " + serverTime + "  time =  " + j3 + " needShow = " + z16);
        }
        if (serverTime - j3 >= richEffectiveTime) {
            com.tencent.aio.api.runtime.a aVar2 = d().get();
            if (aVar2 != null) {
                f306655a.f("", aVar2);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(plainTxt)) {
            com.tencent.aio.api.runtime.a aVar3 = d().get();
            if (aVar3 != null) {
                f306655a.f("", aVar3);
                return;
            }
            return;
        }
        com.tencent.aio.api.runtime.a aVar4 = d().get();
        if (aVar4 != null) {
            cg cgVar = f306655a;
            Intrinsics.checkNotNullExpressionValue(plainTxt, "plainTxt");
            cgVar.f(plainTxt, aVar4);
        }
    }

    private final boolean c(String uin) {
        if (uin == null || TextUtils.isEmpty(uin) || uin.length() < 5 || !TextUtils.isDigitsOnly(uin)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(RichStatus richStatus, String uin) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        if (richStatus != null && !richStatus.isEmpty()) {
            f306655a.b(richStatus);
        } else {
            cg cgVar = f306655a;
            cgVar.b(cgVar.e(uin));
        }
    }

    @NotNull
    public final WeakReference<com.tencent.aio.api.runtime.a> d() {
        WeakReference<com.tencent.aio.api.runtime.a> weakReference = mAIOContext;
        if (weakReference != null) {
            return weakReference;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        return null;
    }

    @Nullable
    public final RichStatus e(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = iFriendsInfoService.getFriendsSimpleInfoWithUid(uid, "RichStatusUtil");
        if (friendsSimpleInfoWithUid != null) {
            return com.tencent.mobileqq.richstatus.c.h(friendsSimpleInfoWithUid);
        }
        return null;
    }

    public final void f(@NotNull String plainTxt, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(plainTxt, "plainTxt");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        if (!TextUtils.isEmpty(plainTxt)) {
            aioContext.e().h(new AIOTitleEvent.TitleResponseEvent(9, new com.tencent.mobileqq.aio.title.aj(true, plainTxt)));
        } else {
            aioContext.e().h(new AIOTitleEvent.TitleResponseEvent(9, new com.tencent.mobileqq.aio.title.aj(false, "")));
        }
    }

    public final void g(@NotNull WeakReference<com.tencent.aio.api.runtime.a> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        mAIOContext = weakReference;
    }

    public final void h(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        AIOParam aIOParam;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        g(new WeakReference<>(aioContext));
        com.tencent.aio.api.runtime.a aVar = d().get();
        if (aVar != null) {
            aIOParam = aVar.g();
        } else {
            aIOParam = null;
        }
        if (aIOParam == null) {
            return;
        }
        final String valueOf = String.valueOf(aIOParam.l().getLong("key_peerUin"));
        if (!c(valueOf)) {
            return;
        }
        final RichStatus e16 = e(valueOf);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.util.cf
            @Override // java.lang.Runnable
            public final void run() {
                cg.i(RichStatus.this, valueOf);
            }
        }, 32, null, true);
    }
}
