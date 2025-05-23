package com.tencent.mobileqq.guild.config;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002J\u0019\u0010\u0005\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/guild/config/GuildDrawerItemConfigParser$Holder$special$$inlined$defineConfig$1", "Lcom/tencent/mobileqq/guild/config/w;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "content", "onParse", "([B)Lcom/tencent/freesia/IConfigData;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onUpdate", "(Lcom/tencent/freesia/IConfigData;)V", "", "account", "onAccountChanged", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "a", "()Landroidx/lifecycle/MutableLiveData;", "liveConfig", "getConfig", "()Lcom/tencent/freesia/IConfigData;", DownloadInfo.spKey_Config, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildDrawerItemConfigParser$Holder$special$$inlined$defineConfig$1 implements w<GuildDrawerItemConfig>, com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<GuildDrawerItemConfig> liveConfig;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f216060e;

    public GuildDrawerItemConfigParser$Holder$special$$inlined$defineConfig$1(final String str) {
        this.f216060e = str;
        final MutableLiveData<GuildDrawerItemConfig> mutableLiveData = new MutableLiveData<>();
        ThreadUtils threadUtils = ThreadUtils.f235400a;
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.config.GuildDrawerItemConfigParser$Holder$special$$inlined$defineConfig$1.1
            @Override // java.lang.Runnable
            public final void run() {
                MutableLiveData mutableLiveData2 = MutableLiveData.this;
                IConfigData loadConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(str);
                if (loadConfig != null) {
                    mutableLiveData2.postValue((GuildDrawerItemConfig) loadConfig);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.config.GuildDrawerItemConfig");
            }
        });
        this.liveConfig = mutableLiveData;
        AccountChangedNotifier.f214789d.a(this);
    }

    @Override // com.tencent.mobileqq.guild.config.w
    @NotNull
    public MutableLiveData<GuildDrawerItemConfig> a() {
        return this.liveConfig;
    }

    @Override // com.tencent.mobileqq.guild.config.w
    @NotNull
    public GuildDrawerItemConfig getConfig() {
        IConfigData loadConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(this.f216060e);
        if (loadConfig != null) {
            return (GuildDrawerItemConfig) loadConfig;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.config.GuildDrawerItemConfig");
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        a().postValue(getConfig());
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.tencent.mobileqq.guild.config.GuildDrawerItemConfig, com.tencent.freesia.IConfigData] */
    @Override // com.tencent.mobileqq.guild.config.a
    @NotNull
    public GuildDrawerItemConfig onParse(@Nullable byte[] content) {
        Object fromJson;
        if (content == null) {
            fromJson = GuildDrawerItemConfig.class.newInstance();
        } else {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            String str = new String(content, UTF_8);
            fromJson = new Gson().fromJson(str, (Class<Object>) GuildDrawerItemConfig.class);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("QQGuildLiteMCParser", "toMCConfig(): " + str + " -> " + fromJson);
            }
        }
        return (IConfigData) fromJson;
    }

    @Override // com.tencent.mobileqq.guild.config.a
    public void onUpdate(@Nullable GuildDrawerItemConfig item) {
        a().postValue(item);
    }
}
