package com.tencent.mobileqq.guild.live.gift.impl;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.guild.gift.module.d;
import com.tencent.mobileqq.guild.live.gift.IGuildLiveGiftInfoManagerService;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J_\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062M\u0010\n\u001aI\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/live/gift/impl/GuildLiveGiftInfoManagerServiceImpl;", "Lcom/tencent/mobileqq/guild/live/gift/IGuildLiveGiftInfoManagerService;", "()V", "getGiftResFilePathByGiftId", "", "giftId", "", "getGiftResFilePathByMaterialId", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "callback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "suc", "filePath", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildLiveGiftInfoManagerServiceImpl implements IGuildLiveGiftInfoManagerService {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/live/gift/impl/GuildLiveGiftInfoManagerServiceImpl$a", "Lcom/tencent/mobileqq/guild/gift/module/d;", "", "success", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "", "pngFilePath", "apngFilePath", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference<Function3<Boolean, Integer, String, Unit>> f226683a;

        a(WeakReference<Function3<Boolean, Integer, String, Unit>> weakReference) {
            this.f226683a = weakReference;
        }

        @Override // com.tencent.mobileqq.guild.gift.module.d
        public void a(boolean success, int materialId, @Nullable String pngFilePath, @Nullable String apngFilePath) {
            Function3<Boolean, Integer, String, Unit> function3 = this.f226683a.get();
            if (function3 != null) {
                function3.invoke(Boolean.valueOf(success), Integer.valueOf(materialId), pngFilePath);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.live.gift.IGuildLiveGiftInfoManagerService
    @Nullable
    public String getGiftResFilePathByGiftId(int giftId) {
        return GLiveChannelCore.f226698a.i().getGiftResFilePathByGiftId(giftId);
    }

    @Override // com.tencent.mobileqq.guild.live.gift.IGuildLiveGiftInfoManagerService
    public void getGiftResFilePathByMaterialId(int materialId, @NotNull Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        GLiveChannelCore.f226698a.i().a(materialId, new a(new WeakReference(callback)));
    }
}
