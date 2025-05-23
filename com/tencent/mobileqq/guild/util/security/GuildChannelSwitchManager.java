package com.tencent.mobileqq.guild.util.security;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelOpenStateResultInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSwitchInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.be;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002,-B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0007J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0007J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0002H\u0016R0\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0016j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0018R0\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0016j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0018R0\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0016j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0018R0\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0016j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R0\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0016j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R0\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0016j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0018R0\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0016j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0018R0\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0016j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u0018R0\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0016j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u0018R0\u0010)\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0016j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\u0018\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/util/security/GuildChannelSwitchManager;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "guildId", "", "d", "f", "g", "", "type", "e", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProSwitchInfo;", "switchInfo", "b", "c", "Lcom/tencent/mobileqq/guild/util/security/GuildChannelSwitchManager$a;", "cb", "pageFrom", "", tl.h.F, "account", "onAccountChanged", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "liveChannelSwitchMap", "voiceChannelSwitchMap", "worldChannelSwitchMap", "i", "worldChannelMapDecorateSwitchMap", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "worldChannelPublicChatSwitchMap", BdhLogUtil.LogTag.Tag_Conn, "textChannelPicSwitchMap", "D", "textChannelVideoSwitchMap", "E", "textChannelFileSwitchMap", UserInfo.SEX_FEMALE, "textChannelEmojiSwitchMap", "G", "mediaChannelAIOSwitchMap", "<init>", "()V", "ChannelSwitchChangeEvent", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildChannelSwitchManager implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private static final HashMap<String, IGProSwitchInfo> textChannelPicSwitchMap;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private static final HashMap<String, IGProSwitchInfo> textChannelVideoSwitchMap;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private static final HashMap<String, IGProSwitchInfo> textChannelFileSwitchMap;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private static final HashMap<String, IGProSwitchInfo> textChannelEmojiSwitchMap;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private static final HashMap<String, IGProSwitchInfo> mediaChannelAIOSwitchMap;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final GuildChannelSwitchManager f235622d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, IGProSwitchInfo> liveChannelSwitchMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, IGProSwitchInfo> voiceChannelSwitchMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, IGProSwitchInfo> worldChannelSwitchMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, IGProSwitchInfo> worldChannelMapDecorateSwitchMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, IGProSwitchInfo> worldChannelPublicChatSwitchMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/util/security/GuildChannelSwitchManager$ChannelSwitchChangeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "guildId", "", "switchInfos", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProSwitchInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getGuildId", "()Ljava/lang/String;", "getSwitchInfos", "()Ljava/util/List;", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class ChannelSwitchChangeEvent extends SimpleBaseEvent {

        @NotNull
        private final String guildId;

        @NotNull
        private final List<IGProSwitchInfo> switchInfos;

        /* JADX WARN: Multi-variable type inference failed */
        public ChannelSwitchChangeEvent(@NotNull String guildId, @NotNull List<? extends IGProSwitchInfo> switchInfos) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(switchInfos, "switchInfos");
            this.guildId = guildId;
            this.switchInfos = switchInfos;
        }

        @NotNull
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        public final List<IGProSwitchInfo> getSwitchInfos() {
            return this.switchInfos;
        }

        @NotNull
        public String toString() {
            int collectionSizeOrDefault;
            String str = this.guildId;
            List<IGProSwitchInfo> list = this.switchInfos;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (IGProSwitchInfo iGProSwitchInfo : list) {
                arrayList.add("(" + iGProSwitchInfo.getSwitchType() + "," + iGProSwitchInfo.getSwitchState() + ")");
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String arrays = Arrays.toString(array);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            return "guildId: " + str + ", switchInfos(type,state): " + arrays;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/util/security/GuildChannelSwitchManager$a;", "", "", "result", "", "msg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface a {
        void onResult(int result, @Nullable String msg2);
    }

    static {
        GuildChannelSwitchManager guildChannelSwitchManager = new GuildChannelSwitchManager();
        f235622d = guildChannelSwitchManager;
        liveChannelSwitchMap = new HashMap<>();
        voiceChannelSwitchMap = new HashMap<>();
        worldChannelSwitchMap = new HashMap<>();
        worldChannelMapDecorateSwitchMap = new HashMap<>();
        worldChannelPublicChatSwitchMap = new HashMap<>();
        textChannelPicSwitchMap = new HashMap<>();
        textChannelVideoSwitchMap = new HashMap<>();
        textChannelFileSwitchMap = new HashMap<>();
        textChannelEmojiSwitchMap = new HashMap<>();
        mediaChannelAIOSwitchMap = new HashMap<>();
        AccountChangedNotifier.f214789d.a(guildChannelSwitchManager);
    }

    GuildChannelSwitchManager() {
    }

    private final boolean b(IGProSwitchInfo switchInfo) {
        if (switchInfo != null && switchInfo.getSwitchState() == 2) {
            return false;
        }
        return true;
    }

    private final boolean c(IGProSwitchInfo switchInfo) {
        if (switchInfo != null && switchInfo.getSwitchState() == 1) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean d(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        IGProSwitchInfo iGProSwitchInfo = liveChannelSwitchMap.get(guildId);
        if (iGProSwitchInfo == null || iGProSwitchInfo.getSwitchState() == 1) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean e(@NotNull String guildId, int type) {
        IGProSwitchInfo iGProSwitchInfo;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        switch (type) {
            case 8:
                iGProSwitchInfo = textChannelPicSwitchMap.get(guildId);
                break;
            case 9:
                iGProSwitchInfo = textChannelVideoSwitchMap.get(guildId);
                break;
            case 10:
                iGProSwitchInfo = textChannelFileSwitchMap.get(guildId);
                break;
            case 11:
                iGProSwitchInfo = textChannelEmojiSwitchMap.get(guildId);
                break;
            default:
                iGProSwitchInfo = null;
                break;
        }
        return f235622d.b(iGProSwitchInfo);
    }

    @JvmStatic
    public static final boolean f(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        IGProSwitchInfo iGProSwitchInfo = voiceChannelSwitchMap.get(guildId);
        if (iGProSwitchInfo == null || iGProSwitchInfo.getSwitchState() == 1) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean g(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return f235622d.c(worldChannelSwitchMap.get(guildId));
    }

    @JvmStatic
    public static final void h(@NotNull final String guildId, @Nullable final a cb5, @NotNull final String pageFrom) {
        ArrayList<Integer> arrayListOf;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
        try {
            long parseLong = Long.parseLong(guildId);
            IRuntimeService runtimeService = ch.l().getRuntimeService(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface()\n         \u2026va, ProcessConstant.MAIN)");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(1, 2, 8, 9, 10, 11, 14);
            ((IGPSService) runtimeService).fetchSpecifiedTypeChannelsOpenState(parseLong, arrayListOf, 0, new be(cb5, guildId, pageFrom) { // from class: com.tencent.mobileqq.guild.util.security.d

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f235630a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f235631b;

                {
                    this.f235630a = guildId;
                    this.f235631b = pageFrom;
                }

                @Override // wh2.be
                public final void a(int i3, String str, IGProChannelOpenStateResultInfo iGProChannelOpenStateResultInfo) {
                    GuildChannelSwitchManager.i(null, this.f235630a, this.f235631b, i3, str, iGProChannelOpenStateResultInfo);
                }
            });
        } catch (NumberFormatException unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "pullChannelSwitch failed, guildId:" + guildId + " pageFrom:" + pageFrom;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.World.GuildChannelSwitchManager", 1, (String) it.next(), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(a aVar, String guildId, String pageFrom, int i3, String str, IGProChannelOpenStateResultInfo iGProChannelOpenStateResultInfo) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(pageFrom, "$pageFrom");
        if (i3 != 0) {
            if (aVar != null) {
                aVar.onResult(i3, str);
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "getChannelEnableFromNet failed, guildId:" + guildId + " pageFrom:" + pageFrom + " code:" + i3 + " msg:" + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.World.GuildChannelSwitchManager", 1, (String) it.next(), null);
            }
            return;
        }
        StringBuilder sb5 = new StringBuilder("pullChannelSwitch guildId:" + guildId + " pageFrom:" + pageFrom + " peakActivityGuildFlag:" + iGProChannelOpenStateResultInfo.getPeakActivityGuildFlag() + " ");
        ArrayList arrayList = new ArrayList();
        ArrayList<IGProSwitchInfo> switchInfoList = iGProChannelOpenStateResultInfo.getSwitchInfoList();
        Intrinsics.checkNotNullExpressionValue(switchInfoList, "stateResultInfo.switchInfoList");
        for (IGProSwitchInfo it5 : switchInfoList) {
            sb5.append("switchType:" + it5.getSwitchType() + " switchState:" + it5.getSwitchState() + " ");
            int switchType = it5.getSwitchType();
            if (switchType != 1) {
                if (switchType != 2) {
                    if (switchType != 14) {
                        switch (switchType) {
                            case 8:
                                HashMap<String, IGProSwitchInfo> hashMap = textChannelPicSwitchMap;
                                Intrinsics.checkNotNullExpressionValue(it5, "it");
                                hashMap.put(guildId, it5);
                                break;
                            case 9:
                                HashMap<String, IGProSwitchInfo> hashMap2 = textChannelVideoSwitchMap;
                                Intrinsics.checkNotNullExpressionValue(it5, "it");
                                hashMap2.put(guildId, it5);
                                break;
                            case 10:
                                HashMap<String, IGProSwitchInfo> hashMap3 = textChannelFileSwitchMap;
                                Intrinsics.checkNotNullExpressionValue(it5, "it");
                                hashMap3.put(guildId, it5);
                                break;
                            case 11:
                                HashMap<String, IGProSwitchInfo> hashMap4 = textChannelEmojiSwitchMap;
                                Intrinsics.checkNotNullExpressionValue(it5, "it");
                                hashMap4.put(guildId, it5);
                                break;
                        }
                    } else {
                        HashMap<String, IGProSwitchInfo> hashMap5 = mediaChannelAIOSwitchMap;
                        Intrinsics.checkNotNullExpressionValue(it5, "it");
                        hashMap5.put(guildId, it5);
                    }
                } else {
                    boolean f16 = f(guildId);
                    HashMap<String, IGProSwitchInfo> hashMap6 = voiceChannelSwitchMap;
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    hashMap6.put(guildId, it5);
                    if (f(guildId) != f16) {
                        arrayList.add(it5);
                    }
                }
            } else {
                boolean d16 = d(guildId);
                HashMap<String, IGProSwitchInfo> hashMap7 = liveChannelSwitchMap;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                hashMap7.put(guildId, it5);
                if (d(guildId) != d16) {
                    arrayList.add(it5);
                }
            }
        }
        if (aVar != null) {
            aVar.onResult(0, "");
        }
        if (!arrayList.isEmpty()) {
            SimpleEventBus.getInstance().dispatchEvent(new ChannelSwitchChangeEvent(guildId, arrayList));
        }
        Logger.a d17 = Logger.f235387a.d();
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "logBuilder.toString()");
        d17.i("Guild.World.GuildChannelSwitchManager", 1, sb6);
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        liveChannelSwitchMap.clear();
        voiceChannelSwitchMap.clear();
        worldChannelSwitchMap.clear();
        worldChannelMapDecorateSwitchMap.clear();
        worldChannelPublicChatSwitchMap.clear();
        textChannelPicSwitchMap.clear();
        textChannelVideoSwitchMap.clear();
        textChannelFileSwitchMap.clear();
        textChannelEmojiSwitchMap.clear();
        mediaChannelAIOSwitchMap.clear();
    }
}
