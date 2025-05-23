package lo4;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.timi.game.web.business.api.race.LivingRaceNativeEvent;
import com.tencent.timi.game.web.business.api.race.LivingRoomInfo;
import kotlin.Metadata;
import mo4.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\tH&J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H&\u00a8\u0006\u0016"}, d2 = {"Llo4/a;", "Lmm4/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "url", "Lcom/tencent/timi/game/web/business/api/race/LivingRoomInfo;", "livingRoomInfo", "", "X", "Landroid/content/Context;", "context", "Y", "K1", "y1", "Z1", "Lmo4/b;", "C2", "Lcom/tencent/timi/game/web/business/api/race/LivingRaceNativeEvent;", "event", "i2", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface a extends mm4.a {
    @NotNull
    b C2();

    void K1();

    void X(@NotNull Activity activity, @NotNull String url, @Nullable LivingRoomInfo livingRoomInfo);

    void Y(@NotNull Context context, @NotNull String url);

    void Z1(@NotNull String url);

    void i2(@NotNull LivingRaceNativeEvent event);

    void y1(@NotNull Context context, @NotNull String url);
}
