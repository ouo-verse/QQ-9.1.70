package com.tencent.mobileqq.proavatar.info.db;

import AvatarInfo.QQHeadInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.utils.c;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.proavatar.ProAvatarComponentInit;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b&\u0010'J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0006\u0010\u000b\u001a\u00020\u0006J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0014\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fR \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001bR\u001c\u0010 \u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010!R\u0014\u0010#\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010!R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/proavatar/info/db/AvatarInfoEntityManager;", "", "LAvatarInfo/QQHeadInfo;", "headInfo", "", "saveToDB", "", "f", "Lcom/tencent/mobileqq/proavatar/info/db/AvatarInfoEntity;", "avatarInfoEntity", "e", "d", "", "key", "readDb", "b", "c", "Lcom/tencent/mobileqq/app/face/FaceInfo;", "faceInfo", "g", "i", "j", "Landroid/util/LruCache;", "a", "Landroid/util/LruCache;", "mAvatarSettingCache", "Lcom/tencent/mobileqq/proavatar/info/db/b;", "Lcom/tencent/mobileqq/proavatar/info/db/b;", "proAvatarEntityManagerFactory", "Lcom/tencent/mobileqq/persistence/EntityManager;", "kotlin.jvm.PlatformType", "Lcom/tencent/mobileqq/persistence/EntityManager;", "entityManager", "Ljava/lang/Object;", "mSettingCacheLock", "mSettingDBInitLock", "Z", "mIsSettingDBInitFinish", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class AvatarInfoEntityManager {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy<Integer> f259621h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LruCache<String, AvatarInfoEntity> mAvatarSettingCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b proAvatarEntityManagerFactory;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final EntityManager entityManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object mSettingCacheLock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object mSettingDBInitLock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mIsSettingDBInitFinish;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/proavatar/info/db/AvatarInfoEntityManager$a;", "", "", "cacheMaxSize$delegate", "Lkotlin/Lazy;", "a", "()I", "cacheMaxSize", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.info.db.AvatarInfoEntityManager$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return ((Number) AvatarInfoEntityManager.f259621h.getValue()).intValue();
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
        Lazy<Integer> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17944);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(AvatarInfoEntityManager$Companion$cacheMaxSize$2.INSTANCE);
        f259621h = lazy;
    }

    public AvatarInfoEntityManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mAvatarSettingCache = new LruCache<>(INSTANCE.a());
        b bVar = new b();
        this.proAvatarEntityManagerFactory = bVar;
        this.entityManager = bVar.createEntityManager();
        this.mSettingCacheLock = new Object();
        this.mSettingDBInitLock = new Object();
    }

    private final void e(AvatarInfoEntity avatarInfoEntity) {
        QLog.i("AvatarInfoEntityManager", 1, "saveToSettingDB state[" + avatarInfoEntity.getStatus() + "] " + avatarInfoEntity);
        if (avatarInfoEntity.getStatus() == 1000) {
            this.entityManager.persistOrReplace(avatarInfoEntity);
        } else if (avatarInfoEntity.getStatus() == 1001 || avatarInfoEntity.getStatus() == 1002) {
            this.entityManager.update(avatarInfoEntity);
        }
    }

    private final void f(QQHeadInfo headInfo, boolean saveToDB) {
        byte b16;
        if (headInfo == null) {
            QLog.e("AvatarInfoEntityManager", 1, "updateAvatarInfoEntity headInfo is null");
            return;
        }
        String j3 = c.j(headInfo.dstUsrType, String.valueOf(headInfo.uin), headInfo.idType);
        AvatarInfoEntity c16 = c(j3);
        if (c16 == null) {
            c16 = new AvatarInfoEntity();
            c16.key = j3;
        }
        c16.bFaceFlags = headInfo.dwFaceFlgas;
        c16.bUsrType = headInfo.dstUsrType;
        c16.url = headInfo.downLoadUrl;
        c16.updateTimestamp = System.currentTimeMillis();
        byte b17 = headInfo.cHeadType;
        if (b17 == 0) {
            b16 = 0;
        } else {
            b16 = headInfo.headLevel;
        }
        c16.bSourceType = b16;
        c16.bHeadType = b17;
        c16.systemHeadID = headInfo.systemHeadID;
        c16.headImgTimestamp = headInfo.dwTimestamp;
        c16.staticZplanFaceFlag = headInfo.staticZplanFaceFlag;
        c16.dynamicZplanFaceFlag = headInfo.dynamicZplanFaceFlag;
        c16.zplanFaceBgUrl = headInfo.zplanFaceBgUrl;
        c16.zplanFaceClipPercent = headInfo.zplanFaceClipPercent;
        c16.apngFaceFlag = headInfo.apngFaceFlag;
        if (saveToDB) {
            e(c16);
        }
        this.mAvatarSettingCache.put(j3, c16);
    }

    static /* synthetic */ void h(AvatarInfoEntityManager avatarInfoEntityManager, QQHeadInfo qQHeadInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        avatarInfoEntityManager.f(qQHeadInfo, z16);
    }

    @Nullable
    public final AvatarInfoEntity b(@Nullable String key, boolean readDb) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AvatarInfoEntity) iPatchRedirector.redirect((short) 3, this, key, Boolean.valueOf(readDb));
        }
        AvatarInfoEntity avatarInfoEntity = null;
        if (key == null) {
            QLog.e("AvatarInfoEntityManager", 1, "getAvatarInfoEntity key is null");
            return null;
        }
        AvatarInfoEntity avatarInfoEntity2 = this.mAvatarSettingCache.get(key);
        if (avatarInfoEntity2 != null) {
            return avatarInfoEntity2;
        }
        if (readDb && (avatarInfoEntity = c(key)) != null) {
            this.mAvatarSettingCache.put(key, avatarInfoEntity);
        }
        return avatarInfoEntity;
    }

    @Nullable
    public final AvatarInfoEntity c(@Nullable String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AvatarInfoEntity) iPatchRedirector.redirect((short) 4, (Object) this, (Object) key);
        }
        AvatarInfoEntity avatarInfoEntity = null;
        if (key == null) {
            return null;
        }
        Entity find = DBMethodProxy.find(this.entityManager, (Class<? extends Entity>) AvatarInfoEntity.class, key);
        if (find instanceof AvatarInfoEntity) {
            avatarInfoEntity = (AvatarInfoEntity) find;
        }
        QLog.i("AvatarInfoEntityManager", 4, "getAvatarInfoEntityFromDB [" + key + "]: " + avatarInfoEntity);
        return avatarInfoEntity;
    }

    public final void d() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!ProAvatarComponentInit.c()) {
            return;
        }
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        synchronized (this.mSettingDBInitLock) {
            int i17 = 0;
            this.mIsSettingDBInitFinish = false;
            List<? extends Entity> query = this.entityManager.query(AvatarInfoEntity.class, new AvatarInfoEntity().getTableName(), false, (String) null, (String[]) null, (String) null, (String) null, "updateTimestamp desc", String.valueOf(INSTANCE.a()));
            if (!(query instanceof List)) {
                query = null;
            }
            if (query != null) {
                int size = query.size();
                if (size > 0) {
                    ArrayList arrayList = new ArrayList();
                    i3 = 0;
                    i16 = 0;
                    for (int i18 = 0; i18 < size; i18++) {
                        AvatarInfoEntity avatarInfoEntity = (AvatarInfoEntity) query.get(i18);
                        if (!TextUtils.isEmpty(avatarInfoEntity.key) && i3 < INSTANCE.a()) {
                            if ((avatarInfoEntity.bSourceType == 1 || avatarInfoEntity.bUsrType == 32) && i16 <= 100) {
                                arrayList.add(avatarInfoEntity);
                                i16++;
                            } else {
                                this.mAvatarSettingCache.put(avatarInfoEntity.key, avatarInfoEntity);
                                i3++;
                            }
                        }
                    }
                    int min = (int) Math.min(100.0d, Math.min(INSTANCE.a() - i3, arrayList.size()));
                    if (min > 0) {
                        while (i17 < min) {
                            AvatarInfoEntity avatarInfoEntity2 = (AvatarInfoEntity) arrayList.get(i17);
                            if (avatarInfoEntity2 != null && !TextUtils.isEmpty(avatarInfoEntity2.key)) {
                                this.mAvatarSettingCache.put(avatarInfoEntity2.key, avatarInfoEntity2);
                            }
                            i17++;
                        }
                    }
                } else {
                    i3 = 0;
                    i16 = 0;
                }
                i17 = size;
            } else {
                i3 = 0;
                i16 = 0;
            }
            this.mIsSettingDBInitFinish = true;
            QLog.d("AvatarInfoEntityManager", 1, "initAvatarInfoCache size: " + i17 + ", " + i3 + ", " + i16 + ", \u8017\u65f6\uff1a" + (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis) + ", Thread: " + Thread.currentThread().getName());
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void g(@Nullable FaceInfo faceInfo) {
        QQHeadInfo qQHeadInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) faceInfo);
        } else {
            if (faceInfo == null || (qQHeadInfo = faceInfo.mHeadInfo) == null) {
                return;
            }
            h(this, qQHeadInfo, false, 2, null);
        }
    }

    public final void i(@Nullable FaceInfo faceInfo) {
        QQHeadInfo qQHeadInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) faceInfo);
        } else {
            if (faceInfo == null || (qQHeadInfo = faceInfo.mHeadInfo) == null) {
                return;
            }
            f(qQHeadInfo, false);
        }
    }

    public final void j(@Nullable String key) {
        boolean z16;
        AvatarInfoEntity c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) key);
            return;
        }
        if (key != null && key.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || (c16 = c(key)) == null) {
            return;
        }
        c16.updateTimestamp = System.currentTimeMillis();
        e(c16);
    }
}
