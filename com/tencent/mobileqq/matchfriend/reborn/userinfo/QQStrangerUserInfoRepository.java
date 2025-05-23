package com.tencent.mobileqq.matchfriend.reborn.userinfo;

import android.os.Parcelable;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\bR \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/userinfo/QQStrangerUserInfoRepository;", "", "", "chatType", "", "tinyId", "", "e", "", "o", "Lcom/tencent/mobileqq/matchfriend/bean/QQStrangerUserInfo;", "k", ITVKPlayerEventListener.KEY_USER_INFO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "openId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "info", "", "save", "r", h.F, "f", "j", "Ljava/util/concurrent/ConcurrentHashMap;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "cache", "Lcom/tencent/mobileqq/matchfriend/reborn/userinfo/e;", "b", "Lkotlin/Lazy;", "l", "()Lcom/tencent/mobileqq/matchfriend/reborn/userinfo/e;", QQPermissionConstants.Permission.STORAGE_GROUP, "Ljava/util/concurrent/atomic/AtomicBoolean;", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasLoad", "d", "Lcom/tencent/mobileqq/matchfriend/bean/QQStrangerUserInfo;", "selfInfo", "Lmqq/app/AppRuntime;", "app", "<init>", "(Lmqq/app/AppRuntime;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerUserInfoRepository {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, QQStrangerUserInfo> cache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy storage;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean hasLoad;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QQStrangerUserInfo selfInfo;

    public QQStrangerUserInfoRepository(final AppRuntime app) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(app, "app");
        this.cache = new ConcurrentHashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.matchfriend.reborn.userinfo.QQStrangerUserInfoRepository$storage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                return new e(AppRuntime.this);
            }
        });
        this.storage = lazy;
        this.hasLoad = new AtomicBoolean(false);
    }

    private final String e(int chatType, long tinyId) {
        return chatType + "_" + tinyId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(QQStrangerUserInfoRepository this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.l().b();
        } catch (Throwable th5) {
            QLog.e("QQStrangerUserInfoRepository", 1, "deleteAll error ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(QQStrangerUserInfoRepository this$0, int i3, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.l().a(i3, String.valueOf(j3));
        } catch (Throwable unused) {
            QLog.e("QQStrangerUserInfoRepository", 1, "deleteUserInfo from db error. chatType=" + i3 + ", tinyId=" + j3);
        }
    }

    private final e l() {
        return (e) this.storage.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(QQStrangerUserInfoRepository this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            for (QQStrangerUserInfo qQStrangerUserInfo : this$0.l().c()) {
                this$0.cache.put(this$0.e(qQStrangerUserInfo.chatType, qQStrangerUserInfo.tinyId), qQStrangerUserInfo);
            }
            this$0.hasLoad.set(true);
            QLog.i("QQStrangerUserInfoRepository", 1, "load from db, size=" + this$0.cache.size());
        } catch (Throwable th5) {
            QLog.e("QQStrangerUserInfoRepository", 1, "load data from db error, ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(QQStrangerUserInfoRepository this$0, QQStrangerUserInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        this$0.l().d(info);
    }

    public final void f() {
        this.cache.clear();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.userinfo.b
            @Override // java.lang.Runnable
            public final void run() {
                QQStrangerUserInfoRepository.g(QQStrangerUserInfoRepository.this);
            }
        }, 32, null, false);
    }

    public final void h(final int chatType, final long tinyId) {
        this.cache.remove(e(chatType, tinyId));
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.userinfo.a
            @Override // java.lang.Runnable
            public final void run() {
                QQStrangerUserInfoRepository.i(QQStrangerUserInfoRepository.this, chatType, tinyId);
            }
        }, 32, null, false);
    }

    public final void j() {
        this.cache.clear();
    }

    public final QQStrangerUserInfo k() {
        if (this.selfInfo == null) {
            this.selfInfo = (QQStrangerUserInfo) QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_NEARBYPRO).getParcelable("qqstranger_self_user_info", QQStrangerUserInfo.class, null, true);
        }
        return this.selfInfo;
    }

    public final QQStrangerUserInfo m(int chatType, String openId) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        for (Map.Entry<String, QQStrangerUserInfo> entry : this.cache.entrySet()) {
            if (entry.getValue().chatType == chatType && Intrinsics.areEqual(entry.getValue().openId, openId)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public final QQStrangerUserInfo n(int chatType, long tinyId) {
        return this.cache.get(e(chatType, tinyId));
    }

    public final void o() {
        if (!this.cache.isEmpty()) {
            QLog.i("QQStrangerUserInfoRepository", 1, "needn't load.");
        } else {
            if (this.hasLoad.get()) {
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.userinfo.d
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerUserInfoRepository.p(QQStrangerUserInfoRepository.this);
                }
            }, 32, null, false);
        }
    }

    public final void r(final QQStrangerUserInfo info, boolean save) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (!info.isValid()) {
            QLog.i("QQStrangerUserInfoRepository", 1, "upsertUserInfo but info invalid.");
            return;
        }
        this.cache.put(e(info.chatType, info.tinyId), info);
        if (save) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.userinfo.c
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerUserInfoRepository.s(QQStrangerUserInfoRepository.this, info);
                }
            }, 32, null, false);
        }
    }

    public final void q(QQStrangerUserInfo userInfo) {
        if (userInfo == null || !userInfo.isValid()) {
            return;
        }
        this.selfInfo = userInfo;
        QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_NEARBYPRO).putParcelable("qqstranger_self_user_info", (Parcelable) userInfo, true);
    }
}
