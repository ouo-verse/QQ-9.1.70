package com.tencent.mobileqq.pymk;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.data.QZoneInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J#\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u000f2\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00142\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u000fJ\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0014J\u0006\u0010\u001d\u001a\u00020\u0014J\u0006\u0010\u001e\u001a\u00020\u0014J\u0006\u0010\u001f\u001a\u00020\u0014R\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/pymk/f;", "", "", "key", "", "dataSource", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "Lcom/tencent/mobileqq/data/QZoneInfo;", "value", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/data/QZoneInfo;Ljava/lang/Integer;)V", "e", "(Ljava/lang/Integer;)Lcom/tencent/mobileqq/data/QZoneInfo;", "", "o", "g", "l", "d", "", DomainData.DOMAIN_NAME, "f", Element.ELEMENT_NAME_TIMES, "k", "b", "j", "a", "p", tl.h.F, "i", "c", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "entity", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f261465a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static MMKVOptionEntityV2 entity;

    static {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        entity = fromV2;
    }

    f() {
    }

    private final String q(String key, Integer dataSource) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "null";
        }
        if (dataSource != null) {
            dataSource.intValue();
            return key + "_" + dataSource + "_" + currentAccountUin;
        }
        return key + "_" + currentAccountUin;
    }

    public final long a() {
        return entity.getLong(r(this, "KEY_GUIDE_CLOSE_LAST_TIMESTAMP", null, 2, null), 0L);
    }

    public final int b() {
        return entity.getInt(r(this, "KEY_GUIDE_CLOSE_TIMES", null, 2, null), 0);
    }

    public final boolean c() {
        boolean z16 = entity.getBoolean(r(this, "KEY_IS_FIRST_TIME_UPDATE_9025", null, 2, null), true);
        if (z16) {
            entity.putBoolean(r(this, "KEY_IS_FIRST_TIME_UPDATE_9025", null, 2, null), false);
        }
        return z16;
    }

    public final String d(int dataSource) {
        String string = entity.getString(q("PYMK_ETAG_FRIST_KEY", Integer.valueOf(dataSource)), "");
        return string == null ? "" : string;
    }

    public final QZoneInfo e(Integer dataSource) {
        return (QZoneInfo) entity.decodeParcelable(q("PYMK_EXP_QZONE_INFO_MMKV_KEY", dataSource), QZoneInfo.class, null);
    }

    public final boolean f(int dataSource) {
        return entity.getBoolean(q("PYMK_IS_END_FRIST_KEY", Integer.valueOf(dataSource)), true);
    }

    public final long g(int dataSource) {
        return entity.decodeLong(q("PYMK_NEXT_REQUEST_TIME_MMKV_KEY", Integer.valueOf(dataSource)), 0L);
    }

    public final boolean h() {
        return entity.getBoolean(r(this, "key_may_know_person_switch", null, 2, null), false);
    }

    public final boolean i() {
        return entity.getBoolean(r(this, "key_may_know_person_switch_has_saved", null, 2, null), false);
    }

    public final void j(long value) {
        entity.putLong(r(this, "KEY_GUIDE_CLOSE_LAST_TIMESTAMP", null, 2, null), value);
    }

    public final void k(int times) {
        entity.putInt(r(this, "KEY_GUIDE_CLOSE_TIMES", null, 2, null), times);
    }

    public final void l(String value, int dataSource) {
        Intrinsics.checkNotNullParameter(value, "value");
        entity.putString(q("PYMK_ETAG_FRIST_KEY", Integer.valueOf(dataSource)), value);
    }

    public final void m(QZoneInfo value, Integer dataSource) {
        entity.encodeParcelable(q("PYMK_EXP_QZONE_INFO_MMKV_KEY", dataSource), value);
    }

    public final void n(boolean value, int dataSource) {
        entity.putBoolean(q("PYMK_IS_END_FRIST_KEY", Integer.valueOf(dataSource)), value);
    }

    public final void o(long value, int dataSource) {
        entity.encodeLong(q("PYMK_NEXT_REQUEST_TIME_MMKV_KEY", Integer.valueOf(dataSource)), value);
    }

    public final void p(boolean value) {
        entity.putBoolean(r(this, "key_may_know_person_switch", null, 2, null), value);
        entity.putBoolean(r(this, "key_may_know_person_switch_has_saved", null, 2, null), true);
    }

    static /* synthetic */ String r(f fVar, String str, Integer num, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            num = null;
        }
        return fVar.q(str, num);
    }
}
