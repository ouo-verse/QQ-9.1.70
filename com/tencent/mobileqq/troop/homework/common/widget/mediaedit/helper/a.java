package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.AudioItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.FileItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ImageItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.VideoItem;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006*\u0001\f\u0018\u0000 \u00192\u00020\u0001:\u0001\u001eB,\u0012#\u0010\"\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\b0\u001b\u00a2\u0006\u0004\b2\u00103J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J$\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00172\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\bR4\u0010\"\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\b0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R0\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0#j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/a;", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/FileItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "troopUin", "", "k", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/AudioItem;", "j", "com/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/a$b", "i", "(Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/AudioItem;)Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/a$b;", "Lcom/tencent/mobileqq/utils/VoicePlayer;", "player", "p", "o", "Landroid/content/Context;", "context", "videoPath", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "l", "f", "g", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "a", "Lkotlin/jvm/functions/Function1;", h.F, "()Lkotlin/jvm/functions/Function1;", "updateCallback", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "pathToPlayer", "c", "Lcom/tencent/mobileqq/utils/VoicePlayer;", "curVoicePlayer", "d", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/AudioItem;", "curAudioItem", "", "e", "J", "lastUpdateProgressTime", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<BaseItem, Unit> updateCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, VoicePlayer> pathToPlayer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private VoicePlayer curVoicePlayer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AudioItem curAudioItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long lastUpdateProgressTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\"\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/a$b", "Lcom/tencent/mobileqq/utils/VoicePlayer$a;", "", "path", "", "duration", "current", "", "c5", "ic", "state", "u4", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements VoicePlayer.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AudioItem f296756d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f296757e;

        b(AudioItem audioItem, a aVar) {
            this.f296756d = audioItem;
            this.f296757e = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) audioItem, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.utils.VoicePlayer.a
        public void c5(@Nullable String path, int duration, int current) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, path, Integer.valueOf(duration), Integer.valueOf(current));
                return;
            }
            this.f296756d.setPlayCountTime(current);
            this.f296756d.setCountTime(duration);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f296757e.lastUpdateProgressTime > 200) {
                this.f296757e.lastUpdateProgressTime = currentTimeMillis;
                this.f296757e.h().invoke(this.f296756d);
            }
        }

        @Override // com.tencent.mobileqq.utils.VoicePlayer.a
        public void ic(@Nullable String path, int duration, int current) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, path, Integer.valueOf(duration), Integer.valueOf(current));
                return;
            }
            QLog.i("HW.MediaEdit.HWNoticeMediaPlayHelper", 1, "playerPause, path:" + path);
            this.f296756d.setPlaying(false);
            this.f296757e.h().invoke(this.f296756d);
        }

        @Override // com.tencent.mobileqq.utils.VoicePlayer.a
        public void u4(int state, @Nullable String path, int duration) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(state), path, Integer.valueOf(duration));
                return;
            }
            QLog.i("HW.MediaEdit.HWNoticeMediaPlayHelper", 1, "playerCompletion, path:" + path + ", state" + state);
            if (path != null) {
                a aVar = this.f296757e;
                VoicePlayer voicePlayer = (VoicePlayer) aVar.pathToPlayer.remove(path);
                if (voicePlayer != null) {
                    voicePlayer.v();
                }
                VoicePlayer voicePlayer2 = aVar.curVoicePlayer;
                if (voicePlayer2 != null) {
                    str = voicePlayer2.o();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, path)) {
                    aVar.o();
                }
            }
            this.f296756d.setPlaying(false);
            this.f296756d.setPlayCountTime(0L);
            this.f296757e.h().invoke(this.f296756d);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46697);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Function1<? super BaseItem, Unit> updateCallback) {
        Intrinsics.checkNotNullParameter(updateCallback, "updateCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) updateCallback);
        } else {
            this.updateCallback = updateCallback;
            this.pathToPlayer = new HashMap<>();
        }
    }

    private final b i(AudioItem item) {
        return new b(item, this);
    }

    private final void j(AudioItem item, Activity activity) {
        boolean z16;
        String str;
        String localPath = item.getLocalPath();
        if (localPath == null) {
            return;
        }
        if (localPath.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        VoicePlayer voicePlayer = this.curVoicePlayer;
        if (voicePlayer != null) {
            str = voicePlayer.o();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, localPath)) {
            QLog.i("HW.MediaEdit.HWNoticeMediaPlayHelper", 1, "is cur player path.");
            VoicePlayer voicePlayer2 = this.curVoicePlayer;
            if (voicePlayer2 != null) {
                p(voicePlayer2, item);
                return;
            }
            return;
        }
        VoicePlayer voicePlayer3 = this.curVoicePlayer;
        if (voicePlayer3 != null) {
            QLog.i("HW.MediaEdit.HWNoticeMediaPlayHelper", 1, "pause cur player.");
            AudioItem audioItem = this.curAudioItem;
            if (audioItem != null) {
                audioItem.setPlaying(false);
            }
            voicePlayer3.s();
        }
        if (this.pathToPlayer.containsKey(localPath)) {
            VoicePlayer voicePlayer4 = this.pathToPlayer.get(localPath);
            if (voicePlayer4 != null) {
                QLog.i("HW.MediaEdit.HWNoticeMediaPlayHelper", 1, "player from map, switch play status.");
                p(voicePlayer4, item);
                this.curAudioItem = item;
                this.curVoicePlayer = voicePlayer4;
                return;
            }
            return;
        }
        VoicePlayer voicePlayer5 = new VoicePlayer(localPath, new Handler(Looper.getMainLooper()));
        voicePlayer5.y(activity);
        voicePlayer5.z();
        voicePlayer5.l(i(item));
        voicePlayer5.A();
        item.setPlaying(true);
        this.curAudioItem = item;
        this.pathToPlayer.put(localPath, voicePlayer5);
        this.curVoicePlayer = voicePlayer5;
        QLog.i("HW.MediaEdit.HWNoticeMediaPlayHelper", 1, "create player.");
        this.updateCallback.invoke(item);
    }

    private final void k(FileItem item, Activity activity, String troopUin) {
        String httpUrl;
        if (item.isLocalFile()) {
            httpUrl = item.getLocalPath();
        } else {
            httpUrl = item.getHttpUrl();
        }
        if (httpUrl == null) {
            return;
        }
        if (item.getFileType() == 0) {
            ((ITroopHWApi) QRoute.api(ITroopHWApi.class)).showOnePicture(activity, httpUrl);
        } else {
            if (item.getFileType() == 2) {
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                n(context, httpUrl);
                return;
            }
            ((ITroopHWApi) QRoute.api(ITroopHWApi.class)).browserNoticeFile(activity, troopUin, item.getFileName(), item.getLocalPath(), item.getFileType(), item.getFileSize());
        }
    }

    public static /* synthetic */ void m(a aVar, BaseItem baseItem, Activity activity, String str, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = null;
        }
        aVar.l(baseItem, activity, str);
    }

    private final void n(Context context, String videoPath) {
        Intent intent = new Intent();
        intent.putExtra("file_send_path", videoPath);
        intent.putExtra(ShortVideoConstants.VIDEO_PLAY_CALLER, 4);
        intent.putExtra(ShortVideoConstants.MESSAGE_CLICK_START, System.currentTimeMillis());
        intent.addFlags(268435456);
        RouteUtils.startActivity(context, intent, "/business/shortvideoplay");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        VoicePlayer voicePlayer = this.curVoicePlayer;
        if (voicePlayer != null) {
            this.pathToPlayer.remove(voicePlayer.o());
            voicePlayer.v();
        }
        this.curVoicePlayer = null;
    }

    private final void p(VoicePlayer player, AudioItem item) {
        boolean isPlaying = item.isPlaying();
        if (isPlaying) {
            if (player != null) {
                player.s();
            }
        } else if (player != null) {
            player.u();
        }
        item.setPlaying(!isPlaying);
        this.updateCallback.invoke(item);
    }

    public final void f(@NotNull BaseItem item) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        String localPath = item.getLocalPath();
        if (localPath == null) {
            return;
        }
        if (localPath.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        QLog.i("HW.MediaEdit.HWNoticeMediaPlayHelper", 1, "deleteItem.");
        VoicePlayer voicePlayer = this.curVoicePlayer;
        if (voicePlayer != null) {
            str = voicePlayer.o();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(localPath, str)) {
            o();
        }
        VoicePlayer remove = this.pathToPlayer.remove(localPath);
        if (remove != null) {
            remove.v();
        }
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.i("HW.MediaEdit.HWNoticeMediaPlayHelper", 1, "destroy. " + this.curVoicePlayer + ", size:" + this.pathToPlayer.size());
        VoicePlayer voicePlayer = this.curVoicePlayer;
        if (voicePlayer != null) {
            voicePlayer.v();
        }
        this.curVoicePlayer = null;
        Collection<VoicePlayer> values = this.pathToPlayer.values();
        Intrinsics.checkNotNullExpressionValue(values, "pathToPlayer.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((VoicePlayer) it.next()).v();
        }
        this.pathToPlayer.clear();
    }

    @NotNull
    public final Function1<BaseItem, Unit> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Function1) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.updateCallback;
    }

    public final void l(@NotNull BaseItem item, @Nullable Activity activity, @Nullable String troopUin) {
        String httpUrl;
        String httpUrl2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, item, activity, troopUin);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof VideoItem) {
            VoicePlayer voicePlayer = this.curVoicePlayer;
            if (voicePlayer != null) {
                voicePlayer.s();
            }
            if (item.isLocalFile()) {
                httpUrl2 = item.getLocalPath();
            } else {
                httpUrl2 = item.getHttpUrl();
            }
            if (httpUrl2 == null) {
                return;
            }
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            n(context, httpUrl2);
            return;
        }
        if (item instanceof ImageItem) {
            if (activity == null) {
                return;
            }
            if (item.isLocalFile()) {
                httpUrl = item.getLocalPath();
            } else {
                httpUrl = item.getHttpUrl();
            }
            if (httpUrl == null) {
                return;
            }
            ((ITroopHWApi) QRoute.api(ITroopHWApi.class)).showOnePicture(activity, httpUrl);
            return;
        }
        if (item instanceof AudioItem) {
            j((AudioItem) item, activity);
            return;
        }
        if (!(item instanceof FileItem) || activity == null) {
            return;
        }
        VoicePlayer voicePlayer2 = this.curVoicePlayer;
        if (voicePlayer2 != null) {
            voicePlayer2.s();
        }
        k((FileItem) item, activity, troopUin);
    }
}
