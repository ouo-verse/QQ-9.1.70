package dz1;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBriefAppInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuildBindingInfoRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wh2.cd;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u001a\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u000e\u001a\u00020\rH\u0002R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R2\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0013j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r`\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R2\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0013j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r`\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R$\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\b0\u001aj\b\u0012\u0004\u0012\u00020\b`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001c\u00a8\u0006 "}, d2 = {"Ldz1/b;", "", "", "guildId", "Ldz1/c;", "callback", "", h.F, "Ldz1/a;", "listener", "e", "g", "i", "", "f", "", "b", "J", "lastRedPointReqTimestamp", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "showRedDot", "d", "showSettingLayout", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "listeners", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long lastRedPointReqTimestamp;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f395264a = new b();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<String, Boolean> showRedDot = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<String, Boolean> showSettingLayout = new HashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<dz1.a> listeners = new HashSet<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"dz1/b$a", "Ldz1/c;", "", "isVisible", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f395269a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f395270b;

        a(String str, c cVar) {
            this.f395269a = str;
            this.f395270b = cVar;
        }

        @Override // dz1.c
        public void a(boolean isVisible) {
            String str = "";
            if (!isVisible) {
                HashMap hashMap = b.showRedDot;
                String str2 = this.f395269a;
                if (str2 != null) {
                    str = str2;
                }
                hashMap.put(str, Boolean.valueOf(isVisible));
                this.f395270b.a(isVisible);
                return;
            }
            boolean f16 = b.f395264a.f();
            HashMap hashMap2 = b.showRedDot;
            String str3 = this.f395269a;
            if (str3 != null) {
                str = str3;
            }
            hashMap2.put(str, Boolean.valueOf(f16));
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.mnr.BindGameSettingManager", 2, "shouldShowRedDot value=" + f16);
            }
            this.f395270b.a(f16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"dz1/b$b", "Lwh2/cd;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetGuildBindingInfoRsp;", "rsp", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: dz1.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C10208b implements cd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f395271a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f395272b;

        C10208b(String str, c cVar) {
            this.f395271a = str;
            this.f395272b = cVar;
        }

        @Override // wh2.cd
        public void a(int result, @Nullable String errMsg, @Nullable IGProGetGuildBindingInfoRsp rsp) {
            int i3;
            int i16;
            ArrayList<IGProBriefAppInfo> boundApps;
            ArrayList<IGProBriefAppInfo> bindableApps;
            boolean z16 = true;
            QLog.i("Guild.mnr.BindGameSettingManager", 1, "[onGetGuildBindingInfoCallback] result[" + result + "], msg[" + errMsg + "]");
            if (result == 0 && this.f395271a != null) {
                b bVar = b.f395264a;
                b.lastRedPointReqTimestamp = System.currentTimeMillis();
                if (rsp != null && (bindableApps = rsp.getBindableApps()) != null) {
                    i3 = bindableApps.size();
                } else {
                    i3 = 0;
                }
                if (rsp != null && (boundApps = rsp.getBoundApps()) != null) {
                    i16 = boundApps.size();
                } else {
                    i16 = 0;
                }
                QLog.i("Guild.mnr.BindGameSettingManager", 1, "[onGetGuildBindingInfoCallback] bindableAppsSize: " + i3 + ", boundAppsSize: " + i16);
                HashMap hashMap = b.showSettingLayout;
                String str = this.f395271a;
                if (i3 + i16 <= 0) {
                    z16 = false;
                }
                hashMap.put(str, Boolean.valueOf(z16));
                c cVar = this.f395272b;
                Boolean bool = (Boolean) b.showSettingLayout.get(this.f395271a);
                if (bool == null) {
                    bool = Boolean.FALSE;
                }
                cVar.a(bool.booleanValue());
                return;
            }
            this.f395272b.a(false);
        }
    }

    b() {
    }

    @JvmStatic
    public static final void e(@NotNull dz1.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f() {
        return bw.L().decodeBool("MMKV_KEY_SHOW_BIND_GAME_RED_POINT", true);
    }

    @JvmStatic
    public static final void g(@NotNull dz1.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    @JvmStatic
    public static final void h(@Nullable String guildId, @NotNull c callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (showRedDot.get(guildId) != null) {
            Boolean bool = showRedDot.get(guildId);
            if (bool != null) {
                z16 = bool.booleanValue();
            } else {
                z16 = false;
            }
            callback.a(z16);
            return;
        }
        i(guildId, new a(guildId, callback));
    }

    @JvmStatic
    public static final void i(@Nullable String guildId, @NotNull c callback) {
        long j3;
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean z16 = true;
        boolean z17 = false;
        if (TextUtils.isEmpty(guildId)) {
            QLog.i("Guild.mnr.BindGameSettingManager", 1, "[shouldShowSettingLayout] invalid guildId: " + guildId);
            callback.a(false);
            return;
        }
        IGPSService iGPSService = (IGPSService) bz.b(IGPSService.class);
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(guildId);
        if (guildInfo == null || guildInfo.getUserType() != 2) {
            z16 = false;
        }
        if (!z16) {
            callback.a(false);
            return;
        }
        if ((System.currentTimeMillis() - lastRedPointReqTimestamp) / 1000 <= 900 && showSettingLayout.get(guildId) != null) {
            QLog.i("Guild.mnr.BindGameSettingManager", 2, "[shouldShowSettingLayout] get from cache");
            Boolean bool = showSettingLayout.get(guildId);
            if (bool != null) {
                z17 = bool.booleanValue();
            }
            callback.a(z17);
            return;
        }
        if (guildId != null) {
            j3 = Long.parseLong(guildId);
        } else {
            j3 = 0;
        }
        iGPSService.getGuildBindingInfo(j3, new C10208b(guildId, callback));
    }
}
