package com.tencent.biz.pubaccount.util;

import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl;
import com.tencent.biz.pubaccount.util.j;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.PublicAccountProfile;
import com.tencent.qqnt.kernel.nativeinterface.PublicAccountSetting;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/biz/pubaccount/util/j;", "", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ&\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0006J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u0006R\u0014\u0010 \u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010#\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0014\u0010$\u001a\u00020\u00158\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010!R\u0014\u0010%\u001a\u00020\u00158\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0014\u0010&\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b+\u0010'\u00a8\u0006."}, d2 = {"Lcom/tencent/biz/pubaccount/util/j$a;", "", "Lcom/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDetailImpl;", "detail", "Lcom/tencent/qqnt/kernel/nativeinterface/PublicAccountProfile;", "c", "", "g", "", "i", "Lcom/tencent/mobileqq/data/PublicAccountInfo;", "info", "d", "", "uin", "", "uid", "nick", "isMsgDisturb", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/PublicAccountInfo;", "", "fromSource", "l", "show", "j", "k", "currentHitExp", "e", "hasUpsert", tl.h.F, "f", "CHANGE_FROM_EXP_TO_NONE", "I", "CHANGE_FROM_NONE_TO_EXP", "CHANGE_NONE", "POS_MSG_LIST", "POS_PA_FOLDER", "PUBLIC_ACCOUNT_FOLD_EXP_HIT_LAST_KEY", "Ljava/lang/String;", "PUBLIC_ACCOUNT_FOLD_EXP_NAME", "PUBLIC_ACCOUNT_FOLD_EXP_NAME_TREAT", "PUBLIC_ACCOUNT_FOLD_HAS_UPSERT_KEY", "TAG", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.pubaccount.util.j$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final PublicAccountProfile c(PublicAccountDetailImpl detail) {
            Long longOrNull;
            PublicAccountProfile publicAccountProfile = new PublicAccountProfile();
            String str = detail.uin;
            Intrinsics.checkNotNullExpressionValue(str, "detail.uin");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
            publicAccountProfile.uin = longOrNull != null ? longOrNull.longValue() : 0L;
            publicAccountProfile.uid = detail.uid;
            publicAccountProfile.nick = detail.name;
            publicAccountProfile.accountPos = Integer.valueOf(PublicAccountUtilImpl.isInPublicAccountFolderStatic(detail.accountFlag2) ? 2 : 3);
            return publicAccountProfile;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(int i3, int i16, String str) {
            QLog.d("PublicAccountFoldUtils", 1, "updatePublicAccountInfo source: " + i3 + " code: " + i16 + " msg: " + str);
            if (i16 == 0 && i3 == 1) {
                j.INSTANCE.h(true);
            }
        }

        public final PublicAccountProfile b(long uin, String uid, String nick, boolean isMsgDisturb) {
            Intrinsics.checkNotNullParameter(uid, "uid");
            Intrinsics.checkNotNullParameter(nick, "nick");
            PublicAccountProfile publicAccountProfile = new PublicAccountProfile();
            publicAccountProfile.uin = uin;
            publicAccountProfile.uid = uid;
            publicAccountProfile.nick = nick;
            publicAccountProfile.isMsgDisturb = Boolean.valueOf(isMsgDisturb);
            return publicAccountProfile;
        }

        public final PublicAccountProfile d(PublicAccountInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            PublicAccountProfile publicAccountProfile = new PublicAccountProfile();
            publicAccountProfile.uin = info.uin;
            publicAccountProfile.uid = info.uid;
            publicAccountProfile.nick = info.name;
            publicAccountProfile.accountPos = Integer.valueOf(PublicAccountUtilImpl.isInPublicAccountFolderStatic(info.accountFlag2) ? 2 : 3);
            publicAccountProfile.isMsgDisturb = Boolean.valueOf(info.isMsgDisturb);
            return publicAccountProfile;
        }

        public final int e(boolean currentHitExp) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String currentUin = peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null;
            if (currentUin == null) {
                currentUin = "";
            }
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            String str = "public_account_fold_exp_last_hit_" + currentUin;
            boolean z16 = fromV2.getBoolean(str, false);
            fromV2.putBoolean(str, currentHitExp);
            QLog.d("PublicAccountFoldUtils", 1, "check need pull full list current: " + currentHitExp + " last: " + z16);
            if (z16 == currentHitExp) {
                return 0;
            }
            return !z16 ? 1 : 2;
        }

        public final boolean f() {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String currentUin = peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null;
            if (currentUin == null) {
                currentUin = "";
            }
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            return fromV2.getBoolean("public_account_fold_has_upsert_" + currentUin, false);
        }

        public final boolean g() {
            return true;
        }

        public final void h(boolean hasUpsert) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String currentUin = peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null;
            if (currentUin == null) {
                currentUin = "";
            }
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            fromV2.putBoolean("public_account_fold_has_upsert_" + currentUin, hasUpsert);
        }

        public final void i() {
            qy.a.f430302a.d("exp_qq_life_service_folder", "exp_qq_life_service_folder_B");
        }

        public final void j(boolean show) {
            int i3;
            com.tencent.qqnt.kernel.nativeinterface.PublicAccountInfo publicAccountInfo = new com.tencent.qqnt.kernel.nativeinterface.PublicAccountInfo();
            PublicAccountSetting publicAccountSetting = new PublicAccountSetting();
            if (show) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            publicAccountSetting.subscribeFolderUnreadFlag = i3;
            publicAccountInfo.setting = publicAccountSetting;
            publicAccountInfo.profiles = new ArrayList<>();
            m(this, publicAccountInfo, 0, 2, null);
        }

        public final void k(PublicAccountDetailImpl detail) {
            ArrayList<PublicAccountProfile> arrayListOf;
            Intrinsics.checkNotNullParameter(detail, "detail");
            PublicAccountProfile c16 = c(detail);
            c16.accountPosUpdateTime = Long.valueOf(NetConnInfoCenter.getServerTimeMillis());
            com.tencent.qqnt.kernel.nativeinterface.PublicAccountInfo publicAccountInfo = new com.tencent.qqnt.kernel.nativeinterface.PublicAccountInfo();
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(c16);
            publicAccountInfo.profiles = arrayListOf;
            m(this, publicAccountInfo, 0, 2, null);
        }

        public final void l(com.tencent.qqnt.kernel.nativeinterface.PublicAccountInfo info, final int fromSource) {
            Intrinsics.checkNotNullParameter(info, "info");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e("PublicAccountFoldUtils", 1, "upsertPublicAccountInfo failed! No runtime!");
                return;
            }
            w msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")).getMsgService();
            if (msgService == null) {
                QLog.e("PublicAccountFoldUtils", 1, "upsertPublicAccountInfo failed! No msgService!");
                return;
            }
            if (info.setting == null) {
                ArrayList<PublicAccountProfile> arrayList = info.profiles;
                if (arrayList == null || arrayList.isEmpty()) {
                    QLog.e("PublicAccountFoldUtils", 1, "upsertPublicAccountInfo failed! Empty setting and empty profile!");
                    return;
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updatePublicAccountInfo unreadFlag: ");
            PublicAccountSetting publicAccountSetting = info.setting;
            sb5.append(publicAccountSetting != null ? publicAccountSetting.subscribeFolderUnreadFlag : null);
            sb5.append(" profile size: ");
            ArrayList<PublicAccountProfile> arrayList2 = info.profiles;
            sb5.append(arrayList2 != null ? arrayList2.size() : 0);
            sb5.append(" source: ");
            sb5.append(fromSource);
            QLog.d("PublicAccountFoldUtils", 1, sb5.toString());
            msgService.updatePublicAccountInfo(info, new IOperateCallback() { // from class: com.tencent.biz.pubaccount.util.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    j.Companion.n(fromSource, i3, str);
                }
            });
        }

        Companion() {
        }

        public static /* synthetic */ void m(Companion companion, com.tencent.qqnt.kernel.nativeinterface.PublicAccountInfo publicAccountInfo, int i3, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                i3 = 0;
            }
            companion.l(publicAccountInfo, i3);
        }
    }
}
