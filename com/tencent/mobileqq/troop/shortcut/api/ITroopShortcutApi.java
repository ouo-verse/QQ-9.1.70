package com.tencent.mobileqq.troop.shortcut.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import et2.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u001b\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\bH&\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH&J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006H&J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0006H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/api/ITroopShortcutApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Let2/c;", "createShortcutVB", "", "troopUin", "", "useNewShortcut", "", "", "notifyDataExpired", "(Ljava/lang/Long;)V", "getDisableCapsule", "getDisableCapsuleSwitch", "getUseNewSwitch", "disableCapsule", "setDisableCapsule", "disableCapsuleSwitch", "setDisableCapsuleSwitch", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopShortcutApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class a {
        public static /* synthetic */ void a(ITroopShortcutApi iTroopShortcutApi, Long l3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    l3 = null;
                }
                iTroopShortcutApi.notifyDataExpired(l3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyDataExpired");
        }
    }

    @NotNull
    c createShortcutVB();

    boolean getDisableCapsule(long troopUin);

    boolean getDisableCapsuleSwitch(long troopUin);

    boolean getUseNewSwitch(long troopUin);

    void notifyDataExpired(@Nullable Long troopUin);

    void setDisableCapsule(long troopUin, boolean disableCapsule);

    void setDisableCapsuleSwitch(long troopUin, boolean disableCapsuleSwitch);

    boolean useNewShortcut(@Nullable String troopUin);
}
