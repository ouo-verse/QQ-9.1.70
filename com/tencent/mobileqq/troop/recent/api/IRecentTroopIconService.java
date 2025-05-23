package com.tencent.mobileqq.troop.recent.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00030\nH&J\u001a\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/recent/api/IRecentTroopIconService;", "Lmqq/app/api/IRuntimeService;", "checkTroopIconListAsync", "", "troopUin", "", "oldDrawableList", "", "Landroid/graphics/drawable/Drawable;", "callback", "Lkotlin/Function2;", "getTroopIconListFromCache", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public interface IRecentTroopIconService extends IRuntimeService {
    void checkTroopIconListAsync(@NotNull String troopUin, @Nullable List<? extends Drawable> oldDrawableList, @NotNull Function2<? super String, ? super List<? extends Drawable>, Unit> callback);

    @Nullable
    List<Drawable> getTroopIconListFromCache(@NotNull String troopUin);
}
