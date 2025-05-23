package com.tencent.qqnt.aio.audiopanel;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.config.AppSetting;
import com.tencent.freesia.IConfigData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.h;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.event.LifeCycleEvent;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.event.ThemeEvent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.lateinit.aioreserve1.AIOReserve1CreateModelIntent;
import com.tencent.mobileqq.aio.panel.AIOPanelMsgIntent;
import com.tencent.mobileqq.aio.panel.a;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.av;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.audiopanel.AudioPanelMsgIntent;
import com.tencent.qqnt.aio.audiopanel.PttUIState;
import com.tencent.qqnt.aio.audiopanel.q;
import com.tencent.qqnt.emotion.relatedemo.l;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0003ORY\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001^B\u000f\u0012\u0006\u00108\u001a\u000203\u00a2\u0006\u0004\b\\\u0010]J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0014H\u0002J \u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0010H\u0002J\u001c\u0010 \u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010#\u001a\u00020\u0010H\u0002J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0010H\u0002J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0010H\u0002J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020'H\u0002J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0016J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020\u0006H\u0016J\u0006\u0010/\u001a\u00020\u0010J\u0006\u00100\u001a\u00020\u0010J\u0006\u00101\u001a\u00020\u0016J\u0006\u00102\u001a\u00020'R\u0017\u00108\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010\tR\u0016\u0010C\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010%R\u0016\u0010E\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010:R\u0018\u0010H\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010GR\u0016\u0010K\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010MR\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010PR\u0014\u0010T\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010SR&\u0010X\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020R0V0U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010WR\u0014\u0010[\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010Z\u00a8\u0006_"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/z;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/qqnt/aio/audiopanel/q;", "Lcom/tencent/qqnt/aio/audiopanel/PttUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "Lcom/tencent/mvi/base/route/k;", "I", "D", UserInfo.SEX_FEMALE, BdhLogUtil.LogTag.Tag_Conn, "Lmqq/app/AppRuntime;", "p", "onResume", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "bEditState", "u", "Lcom/tencent/qqnt/aio/audiopanel/q$l;", "L", "", "path", "Lcom/tencent/mobileqq/ptt/d$a;", "listener", "Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "param", "K", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "sync", "N", "G", "v", ReportConstant.COSTREPORT_PREFIX, "w", ViewStickEventHelper.IS_SHOW, "J", "H", "", "height", "B", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "t", MosaicConstants$JsFunction.FUNC_ON_DESTROY, HippyTKDListViewAdapter.X, "y", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/aio/audiopanel/l;", "d", "Lcom/tencent/qqnt/aio/audiopanel/l;", "getFetcher", "()Lcom/tencent/qqnt/aio/audiopanel/l;", "fetcher", "e", "Z", "isFullScreenAudio", "f", "Ljava/lang/String;", "pcmForVadPath", tl.h.F, "recordCounts", "", "i", "recordingUniSeq", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isSpeakerPhoneOn", "Lcom/tencent/mobileqq/ptt/d;", "Lcom/tencent/mobileqq/ptt/d;", "audioRecord", "Lcom/tencent/qqnt/aio/audiopanel/aa;", "Lcom/tencent/qqnt/aio/audiopanel/aa;", "recordCallback", "Lcom/tencent/mobileqq/qqaudio/audioprocessor/b;", "Lcom/tencent/mobileqq/qqaudio/audioprocessor/b;", "processor", "com/tencent/qqnt/aio/audiopanel/z$b", "Lcom/tencent/qqnt/aio/audiopanel/z$b;", "action", "com/tencent/qqnt/aio/audiopanel/z$c", "Lcom/tencent/qqnt/aio/audiopanel/z$c;", "actionR", "", "Lkotlin/Pair;", "Ljava/util/List;", "messageRList", "com/tencent/qqnt/aio/audiopanel/z$d", "Lcom/tencent/qqnt/aio/audiopanel/z$d;", "mRecordChangeListener", "<init>", "(Lcom/tencent/qqnt/aio/audiopanel/l;)V", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class z extends com.tencent.aio.base.mvvm.b<q, PttUIState> {

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.ptt.d audioRecord;

    /* renamed from: D, reason: from kotlin metadata */
    private aa recordCallback;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.qqaudio.audioprocessor.b processor;

    /* renamed from: F, reason: from kotlin metadata */
    private final b action;

    /* renamed from: G, reason: from kotlin metadata */
    private final c actionR;

    /* renamed from: H, reason: from kotlin metadata */
    private final List<Pair<String, c>> messageRList;

    /* renamed from: I, reason: from kotlin metadata */
    private final d mRecordChangeListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final l fetcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isFullScreenAudio;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String pcmForVadPath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int recordCounts;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long recordingUniSeq;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isSpeakerPhoneOn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/audiopanel/z$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            z.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/audiopanel/z$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        c() {
        }

        @Override // com.tencent.mvi.base.route.b
        public com.tencent.mvi.base.route.k call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return z.this.I(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/qqnt/aio/audiopanel/z$d", "Lcom/tencent/qqnt/aio/audiopanel/ac;", "", "b", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements ac {
        d() {
        }

        @Override // com.tencent.qqnt.aio.audiopanel.ac
        public void a() {
            z.this.s();
        }

        @Override // com.tencent.qqnt.aio.audiopanel.ac
        public void b() {
            z.this.v();
        }
    }

    public z(l fetcher) {
        List<Pair<String, c>> listOf;
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        this.fetcher = fetcher;
        this.pcmForVadPath = "";
        this.recordCounts = -1;
        this.isSpeakerPhoneOn = true;
        this.action = new b();
        c cVar = new c();
        this.actionR = cVar;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new Pair(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOPanelMsgIntent.PttPanelBackEventMsgIntent.class)), cVar));
        this.messageRList = listOf;
        this.mRecordChangeListener = new d();
    }

    private final boolean A(RecordParams.RecorderParam param) {
        IConfigData loadConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100828");
        av avVar = loadConfig instanceof av ? (av) loadConfig : null;
        return avVar != null && avVar.b() && param.f307257f == 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean B(int height) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_audio_panel_need_reset_offset_8990_113338127", true)) {
            if (QLog.isColorLevel()) {
                QLog.d("PttPanelVM", 2, "needResetOffset return, switch is off");
            }
            return true;
        }
        com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        com.tencent.mvi.base.route.k k3 = e16 != null ? e16.k(PanelContainerMsgIntent.GetPanelHeightParamMsgIntent.f116806d) : null;
        h.b bVar = k3 instanceof h.b ? (h.b) k3 : null;
        return bVar != null && bVar.a() - bVar.b() == height;
    }

    private final void D() {
        updateUI(PttUIState.OnPauseState.f349655d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof LifeCycleEvent.OnPause) {
            D();
            return;
        }
        if (intent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            PanelContainerMsgIntent.OnPanelStateChangedMsgIntent onPanelStateChangedMsgIntent = (PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) intent;
            if (onPanelStateChangedMsgIntent.a() != 1000 || onPanelStateChangedMsgIntent.b()) {
                return;
            }
            updateUI(PttUIState.OnHidePanel.f349654d);
            return;
        }
        if (intent instanceof AIOPanelMsgIntent.GetVoice2TextView) {
            View voice2TextPanelView = this.fetcher.getVoice2TextPanelView();
            AIOPanelMsgIntent.GetVoice2TextView getVoice2TextView = (AIOPanelMsgIntent.GetVoice2TextView) intent;
            if (getVoice2TextView.a() == null) {
                getVoice2TextView.b(voice2TextPanelView);
                return;
            }
            return;
        }
        if (intent instanceof ThemeEvent.PostThemeChanged) {
            F();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F() {
        Integer a16;
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(PanelContainerMsgIntent.GetPanelContainerStateMsgIntent.f116805d);
        h.a aVar = k3 instanceof h.a ? (h.a) k3 : null;
        boolean z16 = false;
        if (aVar != null && aVar.c() && (a16 = aVar.a()) != null && a16.intValue() == 1000) {
            z16 = true;
        }
        boolean t16 = AppSetting.t(p().getApplicationContext());
        if (QLog.isColorLevel()) {
            QLog.d("PttPanelVM", 2, "onPostThemeChanged() start isPanelShow = " + z16 + ", isSplitViewMode = " + t16);
        }
        if (z16 && t16) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.HidePanelMsgIntent("PttPanelVM", 1000, false, 4, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G(String path, RecordParams.RecorderParam p16) {
        if (QLog.isColorLevel()) {
            QLog.d("PttPanelVM", 2, "recorderEnd() is called");
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new InputEditTextMsgIntent.SetEditTextEnableState(true, null, 2, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H(boolean isShow) {
        int i3;
        com.tencent.mvi.base.route.j e16;
        com.tencent.mvi.base.route.j e17 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        com.tencent.mvi.base.route.k k3 = e17 != null ? e17.k(AIOMsgListEvent.GetBottomLayoutHeight.f188299d) : null;
        l.a aVar = k3 instanceof l.a ? (l.a) k3 : null;
        if (aVar != null) {
            i3 = aVar.a();
            if (i3 <= 0) {
                i3 = e.f349690a;
            }
            QLog.d("PttPanelVM", 1, "setAioBottomBlurViewVisibility " + isShow + ", height=" + i3);
        } else {
            i3 = 0;
        }
        if (!isShow) {
            com.tencent.mvi.base.route.j e18 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
            if (e18 != null) {
                e18.h(new AIOReserve1CreateModelIntent("aio_blur_bottom", InputEvent.AIOBottomBlurHide.f188558d));
            }
            com.tencent.mvi.base.route.j e19 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
            if (e19 != null) {
                e19.h(new PanelContainerMsgIntent.SetPanelHeightOffsetMsgIntent("PttPanelVM", i3, true));
                return;
            }
            return;
        }
        com.tencent.mvi.base.route.j e26 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        if (e26 != null) {
            e26.h(new AIOReserve1CreateModelIntent("aio_blur_bottom", InputEvent.AIOBottomBlurShow.f188559d));
        }
        if (!B(i3) || (e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e()) == null) {
            return;
        }
        e16.h(new PanelContainerMsgIntent.SetPanelHeightOffsetMsgIntent("PttPanelVM", 0, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k I(MsgIntent intent) {
        if (intent instanceof AIOPanelMsgIntent.PttPanelBackEventMsgIntent) {
            PttUIState.OnBackStace onBackStace = new PttUIState.OnBackStace(false);
            updateUI(onBackStace);
            return new a.C7336a(onBackStace.getIsIntercept());
        }
        return pn0.b.f426490a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void J(boolean isShow) {
        MultiSelectEvent.GetSelectMode getSelectMode = new MultiSelectEvent.GetSelectMode(false, 1, null);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(getSelectMode);
        boolean a16 = getSelectMode.a();
        LongShotMsgIntent.GetShotMode getShotMode = new LongShotMsgIntent.GetShotMode(false, 1, null);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(getShotMode);
        boolean a17 = getShotMode.a();
        if (QLog.isColorLevel()) {
            QLog.d("PttPanelVM", 1, "setAioInputShortcutBarVisibility isShow = " + isShow + ", isSelectMode = " + a16 + ", isShotMode = " + a17);
        }
        if (isShow && !a16 && !a17) {
            com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
            if (e16 != null) {
                e16.h(InputEvent.InputShow.f188578d);
            }
            com.tencent.mvi.base.route.j e17 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
            if (e17 != null) {
                e17.h(InputEvent.AIOShortcutBarShow.f188563d);
                return;
            }
            return;
        }
        com.tencent.mvi.base.route.j e18 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        if (e18 != null) {
            e18.h(InputEvent.InputHide.f188577d);
        }
        com.tencent.mvi.base.route.j e19 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        if (e19 != null) {
            e19.h(InputEvent.AIOShortcutBarHide.f188562d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K(String path, d.a listener, RecordParams.RecorderParam param) {
        e.h();
        if (QLog.isColorLevel()) {
            QLog.d("PttPanelVM", 2, "startRecord() is called, param: RecorderParam(mSampleRate: " + param.f307255d + ", mBitRate: " + param.f307256e + ", mAudioType: " + param.f307257f + ", isVoiceChange: " + param.F + ")");
        }
        aa aaVar = null;
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new InputEditTextMsgIntent.SetEditTextEnableState(false, null, 2, null));
        com.tencent.mobileqq.qqaudio.audioprocessor.b bVar = new com.tencent.mobileqq.qqaudio.audioprocessor.b();
        this.processor = bVar;
        if (param.f307257f == 0) {
            bVar.c(new AmrInputStreamWrapper(((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext()));
        } else {
            bVar.c(new SilkCodecWrapper(((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext()));
        }
        com.tencent.mobileqq.qqaudio.audioprocessor.b bVar2 = this.processor;
        if (bVar2 != null) {
            bVar2.b(param.f307255d, param.f307256e, param.f307257f);
        }
        if (this.audioRecord == null) {
            this.audioRecord = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).createQQRecorder(((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext());
        }
        if (A(param)) {
            String vFSPath = RmVFSUtils.getVFSPath(AppConstants.SDCARD_PATH + "ppt/", true);
            File file = new File(vFSPath);
            if (!file.exists()) {
                file.mkdir();
            }
            this.pcmForVadPath = vFSPath + "pcmforvad.pcm";
        }
        com.tencent.mobileqq.ptt.d dVar = this.audioRecord;
        if (dVar != null) {
            dVar.e(param);
        }
        com.tencent.mobileqq.ptt.d dVar2 = this.audioRecord;
        if (dVar2 != null) {
            dVar2.d(this.pcmForVadPath);
        }
        aa aaVar2 = this.recordCallback;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordCallback");
            aaVar2 = null;
        }
        aaVar2.a(listener);
        com.tencent.mobileqq.ptt.d dVar3 = this.audioRecord;
        if (dVar3 != null) {
            aa aaVar3 = this.recordCallback;
            if (aaVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recordCallback");
            } else {
                aaVar = aaVar3;
            }
            dVar3.b(aaVar);
        }
        com.tencent.mobileqq.ptt.d dVar4 = this.audioRecord;
        if (dVar4 != null) {
            dVar4.c(path, !param.F);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PttPanelVM", 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
        }
        int i3 = this.recordCounts;
        if (i3 >= 0) {
            this.recordCounts = i3 + 1;
        }
    }

    private final void L(final q.StartRecordEvent intent) {
        try {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_ptt_start_record_9030_121120193", false)) {
                K(intent.getPath(), intent.getListener(), intent.getRecordParams());
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.M(z.this, intent);
                    }
                }, 16, null, false);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("PttPanelVM", 2, "startRecordThread() Throwable", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(z this$0, q.StartRecordEvent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        this$0.K(intent.getPath(), intent.getListener(), intent.getRecordParams());
    }

    private final void N(boolean sync) {
        if (QLog.isColorLevel()) {
            QLog.d("PttPanelVM", 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
        }
        com.tencent.mobileqq.ptt.d dVar = this.audioRecord;
        if (dVar != null) {
            dVar.stop();
        }
        com.tencent.mobileqq.qqaudio.audioprocessor.b bVar = this.processor;
        if (bVar != null) {
            bVar.release();
        }
        if (this.recordingUniSeq != 0 || this.isFullScreenAudio) {
            return;
        }
        AudioUtil.n(R.raw.f169427y, false);
    }

    private final void onResume() {
        this.isSpeakerPhoneOn = com.tencent.mobileqq.qqaudio.audioplayer.c.b(p());
        this.recordCounts = 0;
    }

    private final AppRuntime p() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        return peekAppRuntime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void s() {
        if (w()) {
            QLog.d("PttPanelVM", 1, "handleClearVoiceInputStatus");
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new InputEvent.ClearInputStatusEvent(2, ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void v() {
        if (w()) {
            QLog.d("PttPanelVM", 1, "handleSendVoiceInputStatus");
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new InputEvent.SendVoiceInputStatusEvent(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean w() {
        return ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e() == 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean z() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        return ((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotAIO(String.valueOf(su3.c.a(g16)), Integer.valueOf(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(LifeCycleEvent.OnPause.class).getQualifiedName(), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent.class.getCanonicalName(), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(ThemeEvent.PostThemeChanged.class.getCanonicalName(), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOPanelMsgIntent.GetVoice2TextView.class)), this.action);
        Iterator<T> it = this.messageRList.iterator();
        while (it.hasNext()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().a((String) ((Pair) it.next()).getFirst());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int q() {
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(PanelContainerMsgIntent.GetPanelHeightParamMsgIntent.f116806d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.input.base.panelcontainer.PanelContainerMsgResult.GetPanelHeightParamMsgResult");
        return ((h.b) k3).a();
    }

    /* renamed from: r, reason: from getter */
    public final String getPcmForVadPath() {
        return this.pcmForVadPath;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void handleIntent(q intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof q.b) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(InputEditTextMsgIntent.ClearEditInputFocus.f189407d);
            return;
        }
        if (intent instanceof q.PanelUIStateChange) {
            u(((q.PanelUIStateChange) intent).getBEditState());
            return;
        }
        if (intent instanceof q.PanelBlurViewChange) {
            H(((q.PanelBlurViewChange) intent).getState());
            return;
        }
        if (intent instanceof q.StartRecordEvent) {
            L((q.StartRecordEvent) intent);
            return;
        }
        if (intent instanceof q.StopRecordEvent) {
            N(((q.StopRecordEvent) intent).getSync());
            return;
        }
        if (intent instanceof q.RecordEndEvent) {
            q.RecordEndEvent recordEndEvent = (q.RecordEndEvent) intent;
            G(recordEndEvent.getPath(), recordEndEvent.getRecordParams());
            return;
        }
        if (intent instanceof q.h) {
            N(false);
            com.tencent.mobileqq.ptt.d dVar = this.audioRecord;
            if (dVar != null) {
                dVar.release();
                return;
            }
            return;
        }
        if (intent instanceof q.SendTextIntent) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgSendEvent.TextSendEvent(((q.SendTextIntent) intent).getText()));
            return;
        }
        if (intent instanceof q.SendIntent) {
            q.SendIntent sendIntent = (q.SendIntent) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgSendEvent.PttSendEvent(sendIntent.getPath(), sendIntent.getDuration(), sendIntent.getAudioType(), sendIntent.a(), sendIntent.getIsVoiceChange(), sendIntent.getIsAutoConvertText(), sendIntent.getVoiceChangeType(), sendIntent.getMsgId()));
            return;
        }
        if (intent instanceof q.SendFakeIntent) {
            q.SendFakeIntent sendFakeIntent = (q.SendFakeIntent) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgSendEvent.PttFakeSendEvent(sendFakeIntent.getPath(), sendFakeIntent.getDuration(), sendFakeIntent.getAudioType(), sendFakeIntent.a(), sendFakeIntent.getIsVoiceChange(), sendFakeIntent.getIsAutoConvertText(), sendFakeIntent.getVoiceChangeType(), sendFakeIntent.getMsgId()));
        } else if (intent instanceof q.CancelFakeIntent) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgSendEvent.PttFakeCancelEvent(((q.CancelFakeIntent) intent).getMsgId()));
        } else if (intent instanceof q.GetChatType) {
            ((q.GetChatType) intent).a(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e());
        } else if (intent instanceof q.GetAIOTypeIntent) {
            ((q.GetAIOTypeIntent) intent).b(z());
        }
    }

    public final boolean x() {
        com.tencent.mobileqq.ptt.d dVar = this.audioRecord;
        boolean z16 = false;
        if (dVar != null && dVar.a()) {
            z16 = true;
        }
        return !z16;
    }

    public final boolean y() {
        com.tencent.mobileqq.ptt.d dVar = this.audioRecord;
        return dVar != null && dVar.isRecording();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(LifeCycleEvent.OnPause.class).getQualifiedName(), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent.class.getCanonicalName(), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(ThemeEvent.PostThemeChanged.class.getCanonicalName(), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOPanelMsgIntent.GetVoice2TextView.class)), this.action);
        Iterator<T> it = this.messageRList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().j((String) pair.getFirst(), (com.tencent.mvi.base.route.b) pair.getSecond());
        }
        this.recordCallback = new aa(this.mRecordChangeListener);
        this.isFullScreenAudio = ((IFeatureRuntimeService) p().getRuntimeService(IFeatureRuntimeService.class, "")).isFeatureSwitchEnable("full_screen_audio");
        C();
        onResume();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u(boolean bEditState) {
        J(!bEditState);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AudioPanelMsgIntent.AudioPanelStatusChangedMsgIntent(bEditState));
    }

    private final void C() {
    }
}
