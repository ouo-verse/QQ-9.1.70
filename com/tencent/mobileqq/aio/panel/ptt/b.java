package com.tencent.mobileqq.aio.panel.ptt;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.aio.panel.ptt.a;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qmethod.pandoraex.monitor.PermissionMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.audio.view.AudioPanel;
import com.tencent.qqnt.audio.view.f;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\t*\u0001>\u0018\u0000 D2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\u0012\u0010\u001a\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0016J2\u0010!\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001c\u001a\u00020\u001b2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fH\u0016J\b\u0010\"\u001a\u00020\rH\u0016R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/ptt/b;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/panel/ptt/a;", "Lcom/tencent/mobileqq/aio/panel/ptt/PttUIState;", "Lcom/tencent/qqnt/audio/view/f;", "", "b1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "", "bindViewAndData", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "state", "d1", "", "getAudioPath", "startRecord", "sync", "j", "audioPath", "n0", "", "totalTime", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "audioData", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/audio/view/AudioPanel;", "e", "Lcom/tencent/qqnt/audio/view/AudioPanel;", "mPanel", "Lcom/tencent/mobileqq/aio/panel/ptt/d;", "f", "Lcom/tencent/mobileqq/aio/panel/ptt/d;", "mRecordCallback", h.F, "Ljava/lang/String;", "mAudioPath", "Lcom/tencent/mobileqq/ptt/d;", "i", "Lcom/tencent/mobileqq/ptt/d;", "mAudioRecord", "Lcom/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer;", "mAudioPlayer", "", BdhLogUtil.LogTag.Tag_Conn, "I", "mAudioType", "com/tencent/mobileqq/aio/panel/ptt/b$b", "D", "Lcom/tencent/mobileqq/aio/panel/ptt/b$b;", "mRecordChangeListener", "<init>", "()V", "E", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b extends com.tencent.aio.base.mvvm.a<a, PttUIState> implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final int mAudioType;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final C7341b mRecordChangeListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AudioPanel mPanel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private d mRecordCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mAudioPath;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.ptt.d mAudioRecord;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private CommonAudioPlayer mAudioPlayer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/ptt/b$a;", "", "", "FILE_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.panel.ptt.b$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/aio/panel/ptt/b$b", "Lcom/tencent/mobileqq/aio/panel/ptt/e;", "", "b", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.panel.ptt.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C7341b implements e {
        static IPatchRedirector $redirector_;

        C7341b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.aio.panel.ptt.e
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                b.this.sendIntent(a.C7340a.f193131d);
            }
        }

        @Override // com.tencent.mobileqq.aio.panel.ptt.e
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                b.this.sendIntent(a.c.f193136d);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64549);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAudioType = 1;
            this.mRecordChangeListener = new C7341b();
        }
    }

    private final boolean b1() {
        Context context = this.context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        if (context.checkSelfPermission(QQPermissionConstants.Permission.RECORD_AUDIO) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.bindViewAndData();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, PttUIState> getViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new c();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull PttUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
        } else {
            Intrinsics.checkNotNullParameter(state, "state");
        }
    }

    @Override // com.tencent.qqnt.audio.view.f
    @Nullable
    public String getAudioPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mAudioPath;
    }

    @Override // com.tencent.qqnt.audio.view.f
    public void j(boolean sync) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, sync);
            return;
        }
        com.tencent.mobileqq.ptt.d dVar = this.mAudioRecord;
        if (dVar != null) {
            dVar.stop();
        }
    }

    @Override // com.tencent.qqnt.audio.view.f
    public void n0(@Nullable String audioPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) audioPath);
            return;
        }
        CommonAudioPlayer commonAudioPlayer = this.mAudioPlayer;
        if (commonAudioPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
            commonAudioPlayer = null;
        }
        Intrinsics.checkNotNull(audioPath);
        commonAudioPlayer.u(audioPath);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        this.context = createViewParams.a();
        Context context = this.context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        this.mAudioPlayer = new CommonAudioPlayer(context, null);
        Context context2 = this.context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context2 = null;
        }
        this.mPanel = new AudioPanel(context2);
        AudioPanel audioPanel = this.mPanel;
        if (audioPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanel");
            audioPanel = null;
        }
        this.mRecordCallback = new d(audioPanel, this.mRecordChangeListener, new com.tencent.qqnt.audio.record.writer.e(null));
        AudioPanel audioPanel2 = this.mPanel;
        if (audioPanel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanel");
            audioPanel2 = null;
        }
        audioPanel2.setListener(this);
        AudioPanel audioPanel3 = this.mPanel;
        if (audioPanel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanel");
            audioPanel3 = null;
        }
        audioPanel3.f();
        AudioPanel audioPanel4 = this.mPanel;
        if (audioPanel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanel");
            return null;
        }
        return audioPanel4;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) reuseParam);
        } else {
            Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
            super.onReuseView(reuseParam);
        }
    }

    @Override // com.tencent.qqnt.audio.view.f
    public void startRecord() {
        RecordParams.RecorderParam recorderParam;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (!b1()) {
            QLog.i("PttPanelVB", 1, "startRecord has no permissions requestRecordAudioPermission");
            z();
            return;
        }
        if (this.mAudioRecord == null) {
            this.mAudioRecord = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).createQQRecorder(BaseApplication.getContext());
        }
        Context context = this.context;
        d dVar = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        File externalFilesDir = context.getExternalFilesDir("audio");
        Intrinsics.checkNotNull(externalFilesDir);
        String absolutePath = externalFilesDir.getAbsolutePath();
        this.mAudioPath = absolutePath;
        if (this.mAudioType == 0) {
            this.mAudioPath = absolutePath + "/amr/" + System.currentTimeMillis();
            recorderParam = new RecordParams.RecorderParam(RecordParams.f307250a, 16000, 0);
        } else {
            this.mAudioPath = absolutePath + "/silk/" + System.currentTimeMillis();
            recorderParam = new RecordParams.RecorderParam(RecordParams.f307251b, 16000, 1);
        }
        com.tencent.mobileqq.ptt.d dVar2 = this.mAudioRecord;
        if (dVar2 != null) {
            dVar2.e(recorderParam);
        }
        com.tencent.mobileqq.ptt.d dVar3 = this.mAudioRecord;
        if (dVar3 != null) {
            d dVar4 = this.mRecordCallback;
            if (dVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecordCallback");
            } else {
                dVar = dVar4;
            }
            dVar3.b(dVar);
        }
        com.tencent.mobileqq.ptt.d dVar5 = this.mAudioRecord;
        if (dVar5 != null) {
            String str = this.mAudioPath;
            Intrinsics.checkNotNull(str);
            dVar5.start(str);
        }
    }

    @Override // com.tencent.qqnt.audio.view.f
    public void y(@Nullable String audioPath, float totalTime, @NotNull ArrayList<Byte> audioData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, audioPath, Float.valueOf(totalTime), audioData);
            return;
        }
        Intrinsics.checkNotNullParameter(audioData, "audioData");
        if (audioPath == null) {
            QLog.i("PttPanelVB", 1, "sendMessage audioPath=null");
            return;
        }
        if (!new File(audioPath).exists()) {
            QLog.i("PttPanelVB", 1, "sendMessage audioPath=" + audioPath + ",is no exists");
            return;
        }
        QLog.i("PttPanelVB", 1, "sendMessage audioPath=" + audioPath + ",totalTime=" + totalTime + ",AudioType=" + this.mAudioType);
        sendIntent(new a.b(audioPath, totalTime, this.mAudioType, audioData));
    }

    @Override // com.tencent.qqnt.audio.view.f
    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        Context context = this.context;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        if (!(context instanceof Activity)) {
            return;
        }
        Context context3 = this.context;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        } else {
            context2 = context3;
        }
        PermissionMonitor.requestPermissions((Activity) context2, new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}, 1);
    }
}
