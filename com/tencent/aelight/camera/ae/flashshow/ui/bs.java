package com.tencent.aelight.camera.ae.flashshow.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.view.KeyEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.editor.music.event.WinkMusicLyricEvent;
import com.tencent.mobileqq.wink.editor.music.lyric.d;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001f\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010C\u001a\u00020B\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J1\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0014J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u0006\u0010\u0019\u001a\u00020\u0004J\u0016\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\bJ\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010$\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"0!j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"`#H\u0016R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010:\u00a8\u0006F"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/bs;", "Llq/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "t", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "editorMusicInfo", "", "savedMusicStartTimeInMs", "", "videoClipDurationInMs", "", "forceRefreshWaveView", "y", "(Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;Ljava/lang/Integer;JZ)V", "videoClipProgressInMs", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "w", "position", HippyTKDListViewAdapter.X, "e", "j", tl.h.F, ReportConstant.COSTREPORT_PREFIX, "startTimeInMs", "endTimeInMs", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "musicProgressInMs", "B", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;", "unit", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/a;", "musicPlayerViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "D", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "musicSourceViewModel", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowBottomPanelViewModel;", "E", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowBottomPanelViewModel;", "bottomPanelViewModel", "Lcom/tencent/mobileqq/wink/editor/music/lyric/d;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/editor/music/lyric/d;", "lyricPanelDialog", "G", "I", "musicWaveViewWidth", "H", "musicWaveViewHeight", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Llq/b;", "partManager", "<init>", "(Landroid/app/Activity;Landroid/view/View;Llq/b;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class bs extends lq.a implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.wink.editor.music.viewmodel.a musicPlayerViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private MusicSourceViewModel musicSourceViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private AEFlashShowBottomPanelViewModel bottomPanelViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.mobileqq.wink.editor.music.lyric.d lyricPanelDialog;

    /* renamed from: G, reason: from kotlin metadata */
    private int musicWaveViewWidth;

    /* renamed from: H, reason: from kotlin metadata */
    private int musicWaveViewHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final AEFlashShowCameraUnit unit;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs(Activity activity, View rootView, lq.b partManager) {
        super(activity, rootView, partManager);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(partManager, "partManager");
        Object b16 = partManager.b(65537, new Object[0]);
        Intrinsics.checkNotNullExpressionValue(b16, "partManager.get(VSCaptur\u2026.MANAGER_GET_ACTION_UNIT)");
        this.unit = (AEFlashShowCameraUnit) b16;
        this.musicWaveViewWidth = ViewUtils.getScreenWidth();
        this.musicWaveViewHeight = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.djc);
    }

    private final void t() {
        Activity A = this.unit.A();
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = null;
        FragmentActivity fragmentActivity = A instanceof FragmentActivity ? (FragmentActivity) A : null;
        if (fragmentActivity == null) {
            return;
        }
        ViewModel viewModel = com.tencent.aelight.camera.ae.n.a(this.unit).get(AEFlashShowBottomPanelViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(unit).get(AEFlashShow\u2026nelViewModel::class.java)");
        this.bottomPanelViewModel = (AEFlashShowBottomPanelViewModel) viewModel;
        ViewModel viewModel2 = new ViewModelProvider(fragmentActivity).get(MusicSourceViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(activi\u2026rceViewModel::class.java)");
        this.musicSourceViewModel = (MusicSourceViewModel) viewModel2;
        Object systemService = this.f415377f.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        ViewModel viewModel3 = new ViewModelProvider(fragmentActivity, new com.tencent.mobileqq.wink.editor.music.viewmodel.f((AudioManager) systemService, Scene.CAMERA)).get(com.tencent.mobileqq.wink.editor.music.viewmodel.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel3, "ViewModelProvider(activi\u2026yerViewModel::class.java)");
        this.musicPlayerViewModel = (com.tencent.mobileqq.wink.editor.music.viewmodel.a) viewModel3;
        if (this.musicSourceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
        }
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar2 = this.musicPlayerViewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
        } else {
            aVar = aVar2;
        }
        aVar.L1().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.br
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                bs.u(bs.this, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void u(bs this$0, Integer num) {
        int i3;
        MusicSourceViewModel musicSourceViewModel;
        MusicSourceViewModel musicSourceViewModel2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long intValue = num.intValue();
        MusicSourceViewModel musicSourceViewModel3 = this$0.musicSourceViewModel;
        MusicSourceViewModel musicSourceViewModel4 = null;
        if (musicSourceViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            musicSourceViewModel3 = null;
        }
        Integer startTimeInMs = musicSourceViewModel3.getStartTimeInMs();
        if (startTimeInMs == null) {
            MusicSourceViewModel musicSourceViewModel5 = this$0.musicSourceViewModel;
            if (musicSourceViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel5 = null;
            }
            MusicInfoWrapper value = musicSourceViewModel5.D2().getValue();
            startTimeInMs = value != null ? Integer.valueOf(value.getStartTime()) : null;
            if (startTimeInMs == null) {
                MusicSourceViewModel musicSourceViewModel6 = this$0.musicSourceViewModel;
                if (musicSourceViewModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                    musicSourceViewModel6 = null;
                }
                WinkEditorMusicInfo currentMusic = musicSourceViewModel6.getCurrentMusic();
                startTimeInMs = currentMusic != null ? Integer.valueOf(currentMusic.s()) : null;
                if (startTimeInMs == null) {
                    i3 = 0;
                    long j3 = intValue - i3;
                    long a16 = com.tencent.mobileqq.wink.editor.music.a.a(j3);
                    musicSourceViewModel = this$0.musicSourceViewModel;
                    if (musicSourceViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                        musicSourceViewModel = null;
                    }
                    if (musicSourceViewModel.getCurrentMusic() != null) {
                        com.tencent.mobileqq.wink.editor.music.lyric.e a17 = com.tencent.mobileqq.wink.editor.music.lyric.e.a();
                        MusicSourceViewModel musicSourceViewModel7 = this$0.musicSourceViewModel;
                        if (musicSourceViewModel7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                            musicSourceViewModel7 = null;
                        }
                        a17.e(a16, musicSourceViewModel7.getVideoDurationMs());
                    }
                    int i16 = (int) j3;
                    musicSourceViewModel2 = this$0.musicSourceViewModel;
                    if (musicSourceViewModel2 != null) {
                        Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                    } else {
                        musicSourceViewModel4 = musicSourceViewModel2;
                    }
                    this$0.z(i16, (int) musicSourceViewModel4.getVideoDurationMs());
                }
            }
        }
        i3 = startTimeInMs.intValue();
        long j36 = intValue - i3;
        long a162 = com.tencent.mobileqq.wink.editor.music.a.a(j36);
        musicSourceViewModel = this$0.musicSourceViewModel;
        if (musicSourceViewModel == null) {
        }
        if (musicSourceViewModel.getCurrentMusic() != null) {
        }
        int i162 = (int) j36;
        musicSourceViewModel2 = this$0.musicSourceViewModel;
        if (musicSourceViewModel2 != null) {
        }
        this$0.z(i162, (int) musicSourceViewModel4.getVideoDurationMs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = this.musicPlayerViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
            aVar = null;
        }
        aVar.O1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = this.musicPlayerViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
            aVar = null;
        }
        aVar.P1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(int position) {
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = this.musicPlayerViewModel;
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
            aVar = null;
        }
        aVar.N1(position);
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar3 = this.musicPlayerViewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
        } else {
            aVar2 = aVar3;
        }
        aVar2.O1();
    }

    private final void y(WinkEditorMusicInfo editorMusicInfo, Integer savedMusicStartTimeInMs, long videoClipDurationInMs, boolean forceRefreshWaveView) {
        int s16;
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar = this.lyricPanelDialog;
        boolean z16 = false;
        if (dVar != null && !dVar.isShowing()) {
            z16 = true;
        }
        if (z16) {
            if (savedMusicStartTimeInMs != null) {
                s16 = savedMusicStartTimeInMs.intValue();
            } else {
                s16 = editorMusicInfo.s();
            }
            com.tencent.mobileqq.wink.editor.music.lyric.d dVar2 = this.lyricPanelDialog;
            if (dVar2 != null) {
                dVar2.c0(editorMusicInfo, s16, (int) videoClipDurationInMs, this.musicWaveViewWidth, this.musicWaveViewHeight, forceRefreshWaveView);
            }
            A(s16, (int) (s16 + videoClipDurationInMs));
            com.tencent.mobileqq.wink.editor.music.lyric.d dVar3 = this.lyricPanelDialog;
            if (dVar3 != null) {
                dVar3.show();
            }
        }
    }

    private final void z(int videoClipProgressInMs, int videoClipDurationInMs) {
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar;
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar2 = this.lyricPanelDialog;
        boolean z16 = false;
        if (dVar2 != null && dVar2.isShowing()) {
            z16 = true;
        }
        if (!z16 || (dVar = this.lyricPanelDialog) == null) {
            return;
        }
        dVar.Z(videoClipProgressInMs, videoClipDurationInMs);
    }

    public final void A(int startTimeInMs, int endTimeInMs) {
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar = this.lyricPanelDialog;
        if (dVar != null) {
            dVar.a0(startTimeInMs, endTimeInMs);
        }
    }

    public final void B(int musicProgressInMs) {
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar;
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar2 = this.lyricPanelDialog;
        boolean z16 = false;
        if (dVar2 != null && dVar2.isShowing()) {
            z16 = true;
        }
        if (!z16 || (dVar = this.lyricPanelDialog) == null) {
            return;
        }
        dVar.b0(musicProgressInMs);
    }

    @Override // lq.a
    protected void e() {
        Activity A = this.unit.A();
        FragmentActivity fragmentActivity = A instanceof FragmentActivity ? (FragmentActivity) A : null;
        if (fragmentActivity == null) {
            return;
        }
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar = new com.tencent.mobileqq.wink.editor.music.lyric.d(fragmentActivity);
        dVar.setOnKeyListener(new a());
        this.lyricPanelDialog = dVar;
        Intrinsics.checkNotNull(dVar);
        dVar.Y(new b());
        t();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(WinkMusicLyricEvent.class);
        return arrayList;
    }

    @Override // lq.a
    public void h() {
        super.h();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // lq.a
    public void j() {
        super.j();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof WinkMusicLyricEvent) {
            WinkMusicLyricEvent winkMusicLyricEvent = (WinkMusicLyricEvent) event;
            y(winkMusicLyricEvent.getEditorMusicInfo(), winkMusicLyricEvent.getSavedMusicStartTimeInMs(), winkMusicLyricEvent.getVideoClipDurationInMs(), winkMusicLyricEvent.getForceRefreshWaveView());
        }
    }

    public final void s() {
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar;
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar2 = this.lyricPanelDialog;
        boolean z16 = false;
        if (dVar2 != null && dVar2.isShowing()) {
            z16 = true;
        }
        if (!z16 || (dVar = this.lyricPanelDialog) == null) {
            return;
        }
        dVar.dismiss();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/ui/bs$b", "Lcom/tencent/mobileqq/wink/editor/music/lyric/d$d;", "", "onMusicWaveMoveStart", "", "startTimeInMs", "endTimeInMs", "onMusicWaveMoving", "", "isDragging", "onMusicWaveMoveEnd", "videoClipPosition", "onIndicatorDragged", "isFromDetachWindow", "onClickCancelBtn", "onClickConfirmBtn", "onResetMusicRangeToRecommend", "show", "positon", "onLyricClick", "onBlankClick", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements d.InterfaceC9031d {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onBlankClick() {
            bs.this.s();
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onClickCancelBtn(boolean isFromDetachWindow) {
            MusicSourceViewModel musicSourceViewModel = bs.this.musicSourceViewModel;
            AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = null;
            if (musicSourceViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel = null;
            }
            musicSourceViewModel.X3();
            if (isFromDetachWindow) {
                return;
            }
            AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel2 = bs.this.bottomPanelViewModel;
            if (aEFlashShowBottomPanelViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
            } else {
                aEFlashShowBottomPanelViewModel = aEFlashShowBottomPanelViewModel2;
            }
            aEFlashShowBottomPanelViewModel.k2().postValue(Boolean.TRUE);
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onClickConfirmBtn() {
            MusicSourceViewModel musicSourceViewModel = bs.this.musicSourceViewModel;
            if (musicSourceViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel = null;
            }
            musicSourceViewModel.Z3();
            MusicSourceViewModel musicSourceViewModel2 = bs.this.musicSourceViewModel;
            if (musicSourceViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel2 = null;
            }
            musicSourceViewModel2.L4();
            MusicSourceViewModel musicSourceViewModel3 = bs.this.musicSourceViewModel;
            if (musicSourceViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel3 = null;
            }
            musicSourceViewModel3.t4(null, null);
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onIndicatorDragged(int videoClipPosition) {
            bs.this.x(videoClipPosition);
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onLyricClick(int positon) {
            bs.this.w();
            bs bsVar = bs.this;
            MusicSourceViewModel musicSourceViewModel = bsVar.musicSourceViewModel;
            MusicSourceViewModel musicSourceViewModel2 = null;
            if (musicSourceViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel = null;
            }
            bsVar.A(positon, ((int) musicSourceViewModel.getVideoDurationMs()) + positon);
            MusicSourceViewModel musicSourceViewModel3 = bs.this.musicSourceViewModel;
            if (musicSourceViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel3 = null;
            }
            Integer valueOf = Integer.valueOf(positon);
            MusicSourceViewModel musicSourceViewModel4 = bs.this.musicSourceViewModel;
            if (musicSourceViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel4 = null;
            }
            musicSourceViewModel3.t4(valueOf, Integer.valueOf(positon + ((int) musicSourceViewModel4.getVideoDurationMs())));
            MusicSourceViewModel musicSourceViewModel5 = bs.this.musicSourceViewModel;
            if (musicSourceViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            } else {
                musicSourceViewModel2 = musicSourceViewModel5;
            }
            musicSourceViewModel2.I4();
            bs.this.v();
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onMusicWaveMoveStart() {
            bs.this.w();
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onMusicWaveMoving(int startTimeInMs, int endTimeInMs) {
            bs.this.A(startTimeInMs, endTimeInMs);
            MusicSourceViewModel musicSourceViewModel = bs.this.musicSourceViewModel;
            if (musicSourceViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel = null;
            }
            musicSourceViewModel.t4(Integer.valueOf(startTimeInMs), Integer.valueOf(endTimeInMs));
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onResetMusicRangeToRecommend(int startTimeInMs) {
            MusicSourceViewModel musicSourceViewModel = bs.this.musicSourceViewModel;
            MusicSourceViewModel musicSourceViewModel2 = null;
            if (musicSourceViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel = null;
            }
            musicSourceViewModel.W3();
            long j3 = startTimeInMs;
            MusicSourceViewModel musicSourceViewModel3 = bs.this.musicSourceViewModel;
            if (musicSourceViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            } else {
                musicSourceViewModel2 = musicSourceViewModel3;
            }
            int videoDurationMs = (int) (j3 + musicSourceViewModel2.getVideoDurationMs());
            bs.this.B(startTimeInMs);
            bs.this.A(startTimeInMs, videoDurationMs);
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void show(boolean show) {
            MusicSourceViewModel musicSourceViewModel = bs.this.musicSourceViewModel;
            if (musicSourceViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel = null;
            }
            musicSourceViewModel.B4(show);
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onMusicWaveMoveEnd(boolean isDragging) {
            if (!isDragging) {
                bs.this.v();
                return;
            }
            MusicSourceViewModel musicSourceViewModel = bs.this.musicSourceViewModel;
            if (musicSourceViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel = null;
            }
            musicSourceViewModel.I4();
            bs.this.v();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/ui/bs$a", "Landroid/content/DialogInterface$OnKeyListener;", "Landroid/content/DialogInterface;", "dialog", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a implements DialogInterface.OnKeyListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode != 4) {
                return false;
            }
            bs.this.s();
            return true;
        }
    }
}
