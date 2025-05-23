package com.tencent.mobileqq.matchfriend.reborn.utils;

import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$GetOptionsRsp;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000f\u001a\u00020\u0004H\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\b\u0010\u0016\u001a\u00020\u0013H\u0007J\b\u0010\u0017\u001a\u00020\u0004H\u0007J\b\u0010\u0018\u001a\u00020\u0002H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\fH\u0007J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\fH\u0007J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0007J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0007J0\u0010$\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0007J(\u0010%\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0007J \u0010)\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\fH\u0007J \u0010*\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\fH\u0007R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/utils/h;", "", "", "j", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "g", "o", "Lcom/tencent/trpcprotocol/kuolie/user_config/user_config/UserConfig$GetOptionsRsp;", "rsp", "w", "e", "", "key", "a", "p", tl.h.F, "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "unread", "v", "d", "u", "c", "tinyId", "r", "k", "selfUin", "toTinyId", ReportConstant.COSTREPORT_PREFIX, "l", "chatType", "", "businessId", "level", DomainData.DOMAIN_NAME, "f", "uid", "peerTinyId", "feedId", "t", "b", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mEntity", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f245480a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final MMKVOptionEntity mEntity;

    static {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        mEntity = from;
    }

    h() {
    }

    @JvmStatic
    public static final boolean b(String uid, long peerTinyId, String feedId) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        return mEntity.decodeBool(f245480a.a("qqstranger_key_has_user_use_quick_reply" + uid + "_" + peerTinyId + "_" + feedId), false);
    }

    @JvmStatic
    public static final boolean c() {
        return mEntity.decodeBool(f245480a.a("qqstranger_key_lite_action_entry_show"), false);
    }

    @JvmStatic
    public static final int d() {
        if (!com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.m.f244621a.a()) {
            return 0;
        }
        return mEntity.decodeInt(f245480a.a("qqstranger_key_lite_action_unread"), 0);
    }

    @JvmStatic
    public static final long f(String selfUin, int chatType, long toTinyId, long businessId) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        return mEntity.decodeLong(f245480a.a("qqstranger_key_gray_tip_show" + selfUin + "_" + chatType + "_" + toTinyId + "_" + businessId), 0L);
    }

    @JvmStatic
    public static final boolean h() {
        return mEntity.decodeBool(f245480a.a("qqstranger_key_has_register_success"), false);
    }

    @JvmStatic
    public static final boolean i() {
        return mEntity.decodeBool(f245480a.a("qqstranger_key_has_show_match_chat_guide"), false);
    }

    @JvmStatic
    public static final boolean k(String tinyId) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        return mEntity.decodeBool(f245480a.a("qqstranger_key_biinteractive_graytips_" + tinyId), false);
    }

    @JvmStatic
    public static final boolean l(String selfUin, String toTinyId) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(toTinyId, "toTinyId");
        return mEntity.decodeBool(f245480a.a("qqstranger_key_lexicon_security_strike_graytips_" + selfUin + "_" + toTinyId), false);
    }

    @JvmStatic
    public static final void m() {
        mEntity.encodeBool(f245480a.a("qqstranger_key_abtest"), true);
    }

    @JvmStatic
    public static final void n(String selfUin, int chatType, long toTinyId, long businessId, long level) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        mEntity.encodeLong(f245480a.a("qqstranger_key_gray_tip_show" + selfUin + "_" + chatType + "_" + toTinyId + "_" + businessId), level);
    }

    @JvmStatic
    public static final void p() {
        mEntity.encodeBool(f245480a.a("qqstranger_key_has_register_success"), true);
    }

    @JvmStatic
    public static final void r(String tinyId) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        mEntity.encodeBool(f245480a.a("qqstranger_key_biinteractive_graytips_" + tinyId), true);
    }

    @JvmStatic
    public static final void s(String selfUin, String toTinyId) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(toTinyId, "toTinyId");
        mEntity.encodeBool(f245480a.a("qqstranger_key_lexicon_security_strike_graytips_" + selfUin + "_" + toTinyId), true);
    }

    @JvmStatic
    public static final void t(String uid, long peerTinyId, String feedId) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        mEntity.encodeBool(f245480a.a("qqstranger_key_has_user_use_quick_reply" + uid + "_" + peerTinyId + "_" + feedId), true);
    }

    @JvmStatic
    public static final void u() {
        mEntity.encodeBool(f245480a.a("qqstranger_key_lite_action_entry_show"), true);
    }

    @JvmStatic
    public static final void v(int unread) {
        mEntity.encodeInt(f245480a.a("qqstranger_key_lite_action_unread"), unread);
    }

    public final String a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_" + key;
    }

    public final UserConfig$GetOptionsRsp e() {
        Object m476constructorimpl;
        byte[] decodeBytes = mEntity.decodeBytes(a("qqstranger_key_msg_setting_data_options"), new byte[0]);
        UserConfig$GetOptionsRsp userConfig$GetOptionsRsp = new UserConfig$GetOptionsRsp();
        if (decodeBytes != null) {
            if (!(decodeBytes.length == 0)) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(userConfig$GetOptionsRsp.mergeFrom(decodeBytes));
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    QLog.e("QQStrangerMMKV", 2, m479exceptionOrNullimpl, new Object[0]);
                }
            }
        }
        return userConfig$GetOptionsRsp;
    }

    public final boolean g() {
        return mEntity.decodeBool(a("qqstranger_key_often_chat_guide_show"), false);
    }

    public final boolean j() {
        return mEntity.decodeBool(a("qqstranger_key_signal_guide_show"), false);
    }

    public final void o() {
        mEntity.encodeBool(a("qqstranger_key_often_chat_guide_show"), true);
    }

    public final void q() {
        mEntity.encodeBool(a("qqstranger_key_signal_guide_show"), true);
    }

    public final void w(UserConfig$GetOptionsRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        mEntity.encodeBytes(a("qqstranger_key_msg_setting_data_options"), rsp.toByteArray());
    }
}
