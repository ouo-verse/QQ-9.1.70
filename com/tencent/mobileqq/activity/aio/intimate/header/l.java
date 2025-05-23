package com.tencent.mobileqq.activity.aio.intimate.header;

import android.text.TextUtils;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.mobileqq.activity.aio.intimate.header.g;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J&\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rJ\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006J\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0006J\u001e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006J\u0016\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0006J\u001e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u001bJ\u0016\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0002J\u001e\u0010!\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001bR\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/header/l;", "", "", "key", "a", "friendUin", "", "currentType", "", "j", "c", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/aio/intimate/header/g;", "Lkotlin/collections/ArrayList;", IQQGameCommApi.K_ABTEST_MODELS, "i", "b", tl.h.F, "count", "o", "type", "g", LocalPhotoFaceInfo.SCORE, DomainData.DOMAIN_NAME, "f", "level", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "", "d", "l", "e", "time", "k", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mEntity", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f179061a = new l();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static MMKVOptionEntity mEntity;

    static {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        mEntity = from;
    }

    l() {
    }

    private final String a(String key) {
        return key + "_" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    @NotNull
    public final ArrayList<g> b(@NotNull String friendUin) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        if (TextUtils.isEmpty(friendUin)) {
            return new ArrayList<>();
        }
        String value = mEntity.decodeString(a("intimate_friend_cache_models_" + friendUin), "");
        g.Companion companion = g.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(value, "value");
        return companion.d(value);
    }

    public final int c(@NotNull String friendUin) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        if (TextUtils.isEmpty(friendUin)) {
            return 0;
        }
        return mEntity.decodeInt(a("intimate_friend_current_card_type_" + friendUin), 0);
    }

    public final boolean d(long type) {
        return mEntity.decodeBool(a("intimate_new_type_" + type), false);
    }

    public final boolean e(long type, @NotNull String friendUin) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        long decodeLong = mEntity.decodeLong(a("intimate_header_card_inter_anim_" + peekAppRuntime.getCurrentUin() + "_" + type + "_" + friendUin), -1L);
        if (((int) decodeLong) != -1 && System.currentTimeMillis() - decodeLong <= 86400000) {
            return false;
        }
        return true;
    }

    public final int f(@NotNull String friendUin, int type) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return 0;
        }
        return mEntity.decodeInt(a("intimate_type_level_" + peekAppRuntime.getCurrentUin() + "_" + type + "_" + friendUin), -1);
    }

    public final int g(@NotNull String friendUin, int type) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return 0;
        }
        return mEntity.decodeInt(a("intimate_progress_bar_" + peekAppRuntime.getCurrentUin() + "_" + type + "_" + friendUin), 0);
    }

    public final int h() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return 0;
        }
        return mEntity.decodeInt(a("friend_relate_entry_count_" + peekAppRuntime.getCurrentUin()), 0);
    }

    public final void i(@NotNull String friendUin, @NotNull ArrayList<g> models) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(models, "models");
        if (TextUtils.isEmpty(friendUin)) {
            return;
        }
        String a16 = a("intimate_friend_cache_models_" + friendUin);
        String jSONArray = g.INSTANCE.b(models).toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "IntimateHeaderCardModel.\u2026toJson(models).toString()");
        mEntity.encodeString(a16, jSONArray);
    }

    public final void j(@NotNull String friendUin, int currentType) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        if (TextUtils.isEmpty(friendUin)) {
            return;
        }
        mEntity.encodeInt(a("intimate_friend_current_card_type_" + friendUin), currentType);
    }

    public final void k(long type, @NotNull String friendUin, long time) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        mEntity.encodeLong(a("intimate_header_card_inter_anim_" + peekAppRuntime.getCurrentUin() + "_" + type + "_" + friendUin), time);
    }

    public final void l(long type) {
        mEntity.encodeBool(a("intimate_new_type_" + type), true);
    }

    public final void m(@NotNull String friendUin, int type, int level) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        mEntity.encodeInt(a("intimate_type_level_" + peekAppRuntime.getCurrentUin() + "_" + type + "_" + friendUin), level);
    }

    public final void n(@NotNull String friendUin, int type, int score) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        mEntity.encodeInt(a("intimate_progress_bar_" + peekAppRuntime.getCurrentUin() + "_" + type + "_" + friendUin), score);
    }

    public final void o(int count) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        mEntity.encodeInt(a("friend_relate_entry_count_" + peekAppRuntime.getCurrentUin()), count);
    }
}
