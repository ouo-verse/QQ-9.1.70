package com.tencent.mobileqq.tux.core;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.tuxmetersdk.export.injector.storage.ITuxStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/tux/core/b;", "Lcom/tencent/tuxmetersdk/export/injector/storage/ITuxStorage;", "", "", "allKeys", "()[Ljava/lang/String;", "key", "", "value", "getLong", "", "getByteArray", "getString", "", "putLong", "putByteArray", "putString", "remove", "trim", JoinPoint.SYNCHRONIZATION_LOCK, JoinPoint.SYNCHRONIZATION_UNLOCK, "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "a", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "mmkvEntity", "<init>", "()V", "qqtux-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b implements ITuxStorage {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MMKVOptionEntityV2 mmkvEntity;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_TUX);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_TUX)");
        this.mmkvEntity = fromV2;
    }

    @Override // com.tencent.tuxmetersdk.export.injector.storage.ITuxStorage
    @Nullable
    public String[] allKeys() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mmkvEntity.allKeys();
    }

    @Override // com.tencent.tuxmetersdk.export.injector.storage.ITuxStorage
    @Nullable
    public byte[] getByteArray(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this, (Object) key);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mmkvEntity.getBytes(key, null);
    }

    @Override // com.tencent.tuxmetersdk.export.injector.storage.ITuxStorage
    public long getLong(@NotNull String key, long value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, this, key, Long.valueOf(value))).longValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mmkvEntity.getLong(key, value);
    }

    @Override // com.tencent.tuxmetersdk.export.injector.storage.ITuxStorage
    @Nullable
    public String getString(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) key);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mmkvEntity.getString(key, null);
    }

    @Override // com.tencent.tuxmetersdk.export.injector.storage.ITuxStorage
    public void lock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.storage.ITuxStorage
    public void putByteArray(@NotNull String key, @Nullable byte[] value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) key, (Object) value);
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            this.mmkvEntity.putBytes(key, value);
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.storage.ITuxStorage
    public void putLong(@NotNull String key, long value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, key, Long.valueOf(value));
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            this.mmkvEntity.putLong(key, value);
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.storage.ITuxStorage
    public void putString(@NotNull String key, @NotNull String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) key, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.mmkvEntity.putString(key, value);
    }

    @Override // com.tencent.tuxmetersdk.export.injector.storage.ITuxStorage
    public void remove(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) key);
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            this.mmkvEntity.remove(key);
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.storage.ITuxStorage
    public void trim() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.mmkvEntity.trim();
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.storage.ITuxStorage
    public void unlock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }
}
