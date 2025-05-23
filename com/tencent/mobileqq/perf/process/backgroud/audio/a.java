package com.tencent.mobileqq.perf.process.backgroud.audio;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import com.google.gson.Gson;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.mobileqq.mediafocus.MediaFocusStackItem;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.music.api.IQQPlayer;
import com.tencent.mobileqq.perf.process.state.floating.IFloatingState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0002J\u001c\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/perf/process/backgroud/audio/a;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/perf/process/backgroud/audio/d;", "Lkotlin/collections/ArrayList;", "g", "f", "d", "b", "e", "Lcom/tencent/mobileqq/perf/process/backgroud/audio/c;", "c", "Lcom/tencent/mobileqq/perf/process/backgroud/audio/e;", "statInfo", "", "i", "Landroid/content/Intent;", "intent", "a", "", "processName", h.F, "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f257816a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31579);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f257816a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final d b() {
        Object firstOrNull;
        try {
            Set<Map.Entry<Long, String>> entrySet = AVBizModuleFactory.getModuleByName("QQ\u76f4\u64ad").getFocusBusiness().entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "module.focusBusiness.entries");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(entrySet);
            Map.Entry entry = (Map.Entry) firstOrNull;
            if (entry != null) {
                QLog.w("AudioStat", 1, "[checkAVAudioFocus] name=" + ((String) entry.getValue()));
                d dVar = new d();
                dVar.f(4);
                Object value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "it.value");
                dVar.d((String) value);
                return dVar;
            }
            return null;
        } catch (Exception e16) {
            QLog.e("AudioStat", 1, "error, ", e16);
            return null;
        }
    }

    private final ArrayList<c> c() {
        ArrayList<c> arrayList;
        Object obj;
        boolean z16;
        try {
            arrayList = new ArrayList<>();
            ArrayList<com.tencent.mobileqq.qqfloatingwindow.a> wrappers = ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).getExistFloatingWrappers();
            for (String str : ((IFloatingState) QRoute.api(IFloatingState.class)).getFloating()) {
                c cVar = new c();
                cVar.d(str);
                Intrinsics.checkNotNullExpressionValue(wrappers, "wrappers");
                Iterator<T> it = wrappers.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((com.tencent.mobileqq.qqfloatingwindow.a) obj).getClass().getName(), str)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                com.tencent.mobileqq.qqfloatingwindow.a aVar = (com.tencent.mobileqq.qqfloatingwindow.a) obj;
                int i3 = 0;
                if (aVar != null && aVar.u() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    i3 = 1;
                }
                cVar.c(i3);
                QLog.i("AudioStat", 1, "[checkFloatWindow] wrapper=" + cVar.b() + ", show=" + cVar.a());
                arrayList.add(cVar);
            }
        } catch (Exception e16) {
            QLog.e("AudioStat", 1, "error, ", e16);
        }
        if (!(!arrayList.isEmpty())) {
            return null;
        }
        return arrayList;
    }

    private final d d() {
        Integer num;
        Boolean bool;
        int i3;
        String trimIndent;
        try {
            QRouteApi api = QRoute.api(IQQPlayer.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IQQPlayer::class.java)");
            IQQPlayer iQQPlayer = (IQQPlayer) api;
            if (iQQPlayer.isPlaying()) {
                SongInfo currentSong = iQQPlayer.getCurrentSong();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[checkMusicService] process=");
                sb5.append(MobileQQ.processName);
                sb5.append(", token=");
                sb5.append(iQQPlayer.getToken());
                sb5.append(", type=");
                if (currentSong != null) {
                    num = Integer.valueOf(currentSong.I);
                } else {
                    num = null;
                }
                sb5.append(num);
                sb5.append(", fromMini=");
                if (currentSong != null) {
                    bool = Boolean.valueOf(currentSong.J);
                } else {
                    bool = null;
                }
                sb5.append(bool);
                QLog.w("AudioStat", 1, sb5.toString());
                d dVar = new d();
                dVar.f(2);
                String token = iQQPlayer.getToken();
                Intrinsics.checkNotNullExpressionValue(token, "player.token");
                dVar.d(token);
                if (currentSong != null) {
                    i3 = currentSong.I;
                } else {
                    i3 = 0;
                }
                trimIndent = StringsKt__IndentKt.trimIndent("\n                            {\n                                \"process\": \"" + MobileQQ.processName + "\",\n                                \"musicType\": " + i3 + "\n                            }\n                        ");
                dVar.e(trimIndent);
                return dVar;
            }
        } catch (Exception e16) {
            QLog.e("AudioStat", 1, "error, ", e16);
        }
        return null;
    }

    private final d e() {
        Object firstOrNull;
        String trimIndent;
        try {
            List<MediaFocusStackItem> g16 = com.tencent.mobileqq.mediafocus.b.i().g();
            if (g16 != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) g16);
                MediaFocusStackItem mediaFocusStackItem = (MediaFocusStackItem) firstOrNull;
                if (mediaFocusStackItem != null) {
                    QLog.w("AudioStat", 1, "[checkNtAudioFocus] " + mediaFocusStackItem);
                    d dVar = new d();
                    dVar.f(8);
                    String a16 = mediaFocusStackItem.a();
                    Intrinsics.checkNotNullExpressionValue(a16, "it.clientId");
                    dVar.d(a16);
                    trimIndent = StringsKt__IndentKt.trimIndent("\n                            {\n                                \"process\": \"" + MobileQQ.processName + "\",\n                                \"focusType\": " + mediaFocusStackItem.b() + "\n                            }\n                        ");
                    dVar.e(trimIndent);
                    return dVar;
                }
                return null;
            }
            return null;
        } catch (Exception e16) {
            QLog.e("AudioStat", 1, "error, ", e16);
            return null;
        }
    }

    private final d f() {
        Object obj;
        int i3;
        String trimIndent;
        try {
            Iterator<T> it = SuperPlayerSDKMgr.getPlayerPool().getAllPlayer().values().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((ISuperPlayer) obj).isPlaying()) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            ISuperPlayer iSuperPlayer = (ISuperPlayer) obj;
            if (iSuperPlayer != null) {
                QLog.w("AudioStat", 1, "[checkSuperPlayer] process=" + MobileQQ.processName + ", sceneId=" + iSuperPlayer.getSceneId() + ", mute=" + iSuperPlayer.isOutputMute());
                d dVar = new d();
                dVar.f(1);
                dVar.d(String.valueOf(iSuperPlayer.getSceneId()));
                if (iSuperPlayer.isOutputMute()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                trimIndent = StringsKt__IndentKt.trimIndent("\n                            {\n                                \"process\": \"" + MobileQQ.processName + "\",\n                                \"mute\": " + i3 + ",\n                                \"playerHashCode\": " + iSuperPlayer.hashCode() + "\n                            }\n                        ");
                dVar.e(trimIndent);
                return dVar;
            }
        } catch (Exception e16) {
            QLog.e("AudioStat", 1, "error, ", e16);
        }
        return null;
    }

    private final ArrayList<d> g() {
        ArrayList<d> arrayList = new ArrayList<>();
        d f16 = f();
        if (f16 != null) {
            arrayList.add(f16);
        }
        d d16 = d();
        if (d16 != null) {
            arrayList.add(d16);
        }
        if (Intrinsics.areEqual(MobileQQ.processName, "com.tencent.mobileqq")) {
            d b16 = b();
            if (b16 != null) {
                arrayList.add(b16);
            }
            d e16 = e();
            if (e16 != null) {
                arrayList.add(e16);
            }
        }
        return arrayList;
    }

    private final void i(e statInfo) {
        String json = new Gson().toJson(statInfo);
        if (QLog.isColorLevel()) {
            QLog.i("AudioStat", 2, "[writeStatInfo] jsonString=" + json);
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String processName = MobileQQ.processName;
        Intrinsics.checkNotNullExpressionValue(processName, "processName");
        from.encodeString(h(processName), json);
    }

    public final void a(@NotNull Intent intent) {
        AudioManager audioManager;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        Object systemService = BaseApplication.context.getSystemService("audio");
        String str = null;
        if (systemService instanceof AudioManager) {
            audioManager = (AudioManager) systemService;
        } else {
            audioManager = null;
        }
        if (audioManager != null) {
            z16 = audioManager.isMusicActive();
        } else {
            z16 = false;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        Bundle extras = intent.getExtras();
        if (extras != null) {
            str = extras.getString("AudioStat_trace_id", valueOf);
        }
        if (str != null) {
            valueOf = str;
        }
        QLog.i("AudioStat", 1, "[check] hasAudio=" + z16 + ", process=" + MobileQQ.processName + ", traceId=" + valueOf);
        if (!z16) {
            QLog.d("AudioStat", 1, "[check] no playing audio, " + MobileQQ.processName);
            return;
        }
        ArrayList<d> g16 = g();
        if (g16.isEmpty()) {
            QLog.d("AudioStat", 1, "[check] no playing infos, " + MobileQQ.processName);
            return;
        }
        e eVar = new e();
        eVar.f(valueOf);
        String processName = MobileQQ.processName;
        Intrinsics.checkNotNullExpressionValue(processName, "processName");
        eVar.e(processName);
        eVar.b().addAll(g16);
        eVar.d(f257816a.c());
        i(eVar);
    }

    @NotNull
    public final String h(@NotNull String processName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) processName);
        }
        Intrinsics.checkNotNullParameter(processName, "processName");
        return "Background_AudioStat_" + processName;
    }
}
