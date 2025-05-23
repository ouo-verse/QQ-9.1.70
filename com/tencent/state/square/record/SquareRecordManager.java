package com.tencent.state.square.record;

import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.IDressKeyChangeListener;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\"\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00042\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0017J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0007J\u0016\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004J*\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/square/record/SquareRecordManager;", "", "()V", "TAG", "", "dressKeyChangeListenerSet", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/state/square/api/IDressKeyChangeListener;", "genderIsMale", "", "guestDressKeyCache", "", "squareDressKey", "cleanup", "", "genGenderIsMale", "getDressKey", "getGender", "", "getGuestCacheDressKey", "uin", "loadLatestDressKey", "callback", "Lkotlin/Function1;", "removeDressKeyChangeListener", "listener", "setDressKeyChangeListener", "setGuestCacheDressKey", "dressKey", "updateDressKey", "logPrefix", "needNotify", "isMale", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class SquareRecordManager {
    private static final String TAG = "SquareRecordManager";

    @NotNull
    public static final SquareRecordManager INSTANCE = new SquareRecordManager();
    private static String squareDressKey = "";
    private static CopyOnWriteArraySet<IDressKeyChangeListener> dressKeyChangeListenerSet = new CopyOnWriteArraySet<>();
    private static boolean genderIsMale = true;
    private static final Map<String, String> guestDressKeyCache = new LinkedHashMap();

    SquareRecordManager() {
    }

    public final String getGuestCacheDressKey(String uin) {
        String str;
        Map<String, String> map = guestDressKeyCache;
        synchronized (map) {
            str = map.get(uin);
        }
        return str;
    }

    public static /* synthetic */ void updateDressKey$default(SquareRecordManager squareRecordManager, String str, String str2, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        squareRecordManager.updateDressKey(str, str2, z16, z17);
    }

    public final void cleanup() {
        dressKeyChangeListenerSet.clear();
        Map<String, String> map = guestDressKeyCache;
        synchronized (map) {
            map.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean genGenderIsMale() {
        return genderIsMale;
    }

    @NotNull
    public final String getDressKey() {
        return squareDressKey;
    }

    public final int getGender() {
        if (genderIsMale) {
            return 1;
        }
        return 2;
    }

    public final void loadLatestDressKey(@NotNull final String uin, @NotNull final Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBase squareBase = SquareBase.INSTANCE;
        if (Intrinsics.areEqual(uin, squareBase.getConfig().getCommonUtils().getCurrentAccountUin())) {
            callback.invoke(getDressKey());
        } else {
            squareBase.getConfig().getRecorder().requestUserDressKey(uin, new Function2<Boolean, String, Unit>() { // from class: com.tencent.state.square.record.SquareRecordManager$loadLatestDressKey$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                    invoke(bool.booleanValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull String dressKey) {
                    String guestCacheDressKey;
                    Intrinsics.checkNotNullParameter(dressKey, "dressKey");
                    SquareBaseKt.getSquareLog().d("SquareRecordManager", "requestDressKey uin:" + uin + " success:" + z16);
                    if (!z16) {
                        dressKey = SquareBase.INSTANCE.getConfig().getRecorder().getCacheUserDressKey(uin);
                    }
                    if (dressKey == null || dressKey.length() == 0) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareRecordManager", "requestDressKey uin:" + uin + " dressKey is empty", null, 4, null);
                        guestCacheDressKey = SquareRecordManager.INSTANCE.getGuestCacheDressKey(uin);
                        if (guestCacheDressKey == null) {
                            guestCacheDressKey = "";
                        }
                        dressKey = guestCacheDressKey;
                    } else {
                        SquareRecordManager.INSTANCE.setGuestCacheDressKey(uin, dressKey);
                    }
                    callback.invoke(dressKey);
                }
            });
        }
    }

    public final void removeDressKeyChangeListener(@NotNull IDressKeyChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        dressKeyChangeListenerSet.remove(listener);
    }

    public final void setDressKeyChangeListener(@NotNull IDressKeyChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        dressKeyChangeListenerSet.add(listener);
    }

    public final void setGuestCacheDressKey(@NotNull String uin, @NotNull String dressKey) {
        boolean z16;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        if (dressKey.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        Map<String, String> map = guestDressKeyCache;
        synchronized (map) {
            map.put(uin, dressKey);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void updateDressKey(@NotNull String dressKey, @NotNull String logPrefix, boolean needNotify, final boolean isMale) {
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        Intrinsics.checkNotNullParameter(logPrefix, "logPrefix");
        SquareBaseKt.getSquareLog().w(TAG, '[' + logPrefix + "]updateDressKey old:" + squareDressKey + ", new: " + dressKey + ", isMale:" + isMale);
        squareDressKey = dressKey;
        genderIsMale = isMale;
        if (needNotify) {
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.record.SquareRecordManager$updateDressKey$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    CopyOnWriteArraySet copyOnWriteArraySet;
                    SquareRecordManager squareRecordManager = SquareRecordManager.INSTANCE;
                    copyOnWriteArraySet = SquareRecordManager.dressKeyChangeListenerSet;
                    Iterator it = copyOnWriteArraySet.iterator();
                    while (it.hasNext()) {
                        ((IDressKeyChangeListener) it.next()).onDressKeyChange(isMale);
                    }
                }
            });
        }
    }
}
