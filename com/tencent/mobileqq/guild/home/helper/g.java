package com.tencent.mobileqq.guild.home.helper;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelOpenStateResultInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSwitchInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.be;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u001aj\b\u0012\u0004\u0012\u00020\u0012`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/home/helper/g;", "", "Lcom/tencent/mobileqq/guild/home/helper/i;", "listener", "", "c", "g", "", "f", "", "guildId", "d", "b", "Z", "scheduleAddressSwitch", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "listeners", "", "I", "incUserJudgmentNumber", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/guild/home/helper/h;", "e", "Ljava/lang/ref/WeakReference;", "incNumberChangeListener", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "switchFetchList", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f224866a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean scheduleAddressSwitch = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArraySet<i> listeners = new CopyOnWriteArraySet<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int incUserJudgmentNumber = -1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<h> incNumberChangeListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<Integer> switchFetchList;

    static {
        ArrayList<Integer> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(18);
        switchFetchList = arrayListOf;
    }

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void e(long j3, int i3, String str, IGProChannelOpenStateResultInfo iGProChannelOpenStateResultInfo) {
        h hVar;
        ArrayList<IGProSwitchInfo> switchInfoList;
        boolean z16;
        h hVar2;
        int i16 = 100;
        IGProSwitchInfo iGProSwitchInfo = null;
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "fetchSpecifiedTypeChannelsOpenState error, " + j3 + " " + i3 + " - " + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.NewHome.GuildSwitchStateHelper", 1, (String) it.next(), null);
            }
            WeakReference<h> weakReference = incNumberChangeListener;
            if (weakReference != null && (hVar2 = weakReference.get()) != null) {
                hVar2.onResult(100);
                return;
            }
            return;
        }
        boolean z17 = false;
        if (iGProChannelOpenStateResultInfo != null && (switchInfoList = iGProChannelOpenStateResultInfo.getSwitchInfoList()) != null) {
            Iterator<T> it5 = switchInfoList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                if (((IGProSwitchInfo) next).getSwitchType() == 18) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    iGProSwitchInfo = next;
                    break;
                }
            }
            iGProSwitchInfo = iGProSwitchInfo;
        }
        if (iGProSwitchInfo != null && iGProSwitchInfo.getSwitchState() != 2) {
            z17 = true;
        }
        scheduleAddressSwitch = z17;
        Iterator<T> it6 = listeners.iterator();
        while (it6.hasNext()) {
            ((i) it6.next()).a(scheduleAddressSwitch);
        }
        int msgNotifyTypeGuildNumber = iGProChannelOpenStateResultInfo.getMsgNotifyTypeGuildNumber();
        if (msgNotifyTypeGuildNumber > 0) {
            i16 = msgNotifyTypeGuildNumber;
        }
        incUserJudgmentNumber = i16;
        WeakReference<h> weakReference2 = incNumberChangeListener;
        if (weakReference2 != null && (hVar = weakReference2.get()) != null) {
            hVar.onResult(incUserJudgmentNumber);
        }
        Logger.f235387a.d().d("Guild.NewHome.GuildSwitchStateHelper", 1, "fetchSpecifiedTypeChannelsOpenState " + j3 + " - " + iGProSwitchInfo + " number=" + msgNotifyTypeGuildNumber + " incUserJudgmentNumber=" + incUserJudgmentNumber);
    }

    public final void c(@NotNull i listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(listener);
    }

    public final void d(final long guildId) {
        ((IGPSService) ch.R0(IGPSService.class)).fetchSpecifiedTypeChannelsOpenState(guildId, switchFetchList, 0, new be() { // from class: com.tencent.mobileqq.guild.home.helper.f
            @Override // wh2.be
            public final void a(int i3, String str, IGProChannelOpenStateResultInfo iGProChannelOpenStateResultInfo) {
                g.e(guildId, i3, str, iGProChannelOpenStateResultInfo);
            }
        });
    }

    public final boolean f() {
        return scheduleAddressSwitch;
    }

    public final void g(@NotNull i listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }
}
