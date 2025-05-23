package com.tencent.mobileqq.wink.editor.music.lyric;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.music.event.WinkMusicLyricEvent;
import com.tencent.mobileqq.wink.editor.music.lyric.d;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u00103\u001a\u00020.\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0014J/\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0004J\u0016\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bJ\u0016\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bJ\u000e\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u000bJ\u0012\u0010)\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010-\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030+0*j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030+`,H\u0016R\u0017\u00103\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/lyric/WinkMusicLyricCropPart;", "Lcom/tencent/mobileqq/wink/editor/d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initViewModel", "Landroidx/lifecycle/MutableLiveData;", "", "J3", "ca", "da", "", "position", "ea", "B9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "initAfterInflation", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "editorMusicInfo", "savedMusicStartTimeInMs", "videoClipDurationInMs", "", "forceRefreshWaveView", "ga", "(Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;Ljava/lang/Integer;JZ)V", "Z9", "startTimeInMs", "endTimeInMs", "ia", "videoClipProgressInMs", "ha", "musicProgressInMs", LocaleUtils.L_JAPANESE, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroidx/lifecycle/ViewModelStoreOwner;", "D", "Landroidx/lifecycle/ViewModelStoreOwner;", "Y9", "()Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "E", "Lkotlin/Lazy;", "X9", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "musicSourceViewModel", "Lcom/tencent/mobileqq/wink/editor/music/lyric/d;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/editor/music/lyric/d;", "lyricPanelDialog", "G", "I", "musicWaveViewWidth", "H", "musicWaveViewHeight", "<init>", "(Landroidx/lifecycle/ViewModelStoreOwner;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMusicLyricCropPart extends com.tencent.mobileqq.wink.editor.d implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ViewModelStoreOwner owner;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy musicSourceViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private d lyricPanelDialog;

    /* renamed from: G, reason: from kotlin metadata */
    private int musicWaveViewWidth;

    /* renamed from: H, reason: from kotlin metadata */
    private int musicWaveViewHeight;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/music/lyric/WinkMusicLyricCropPart$a", "Landroid/content/DialogInterface$OnKeyListener;", "Landroid/content/DialogInterface;", "dialog", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements DialogInterface.OnKeyListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(@Nullable DialogInterface dialog, int keyCode, @Nullable KeyEvent event) {
            if (keyCode == 4) {
                WinkMusicLyricCropPart.this.Z9();
                return true;
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/wink/editor/music/lyric/WinkMusicLyricCropPart$b", "Lcom/tencent/mobileqq/wink/editor/music/lyric/d$d;", "", "onMusicWaveMoveStart", "", "startTimeInMs", "endTimeInMs", "onMusicWaveMoving", "", "isDragging", "onMusicWaveMoveEnd", "videoClipPosition", "onIndicatorDragged", "isFromDetachWindow", "onClickCancelBtn", "onClickConfirmBtn", "onResetMusicRangeToRecommend", "show", "positon", "onLyricClick", "onBlankClick", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements d.InterfaceC9031d {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onBlankClick() {
            WinkMusicLyricCropPart.this.Z9();
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onClickCancelBtn(boolean isFromDetachWindow) {
            WinkMusicLyricCropPart.this.X9().X3();
            if (!isFromDetachWindow) {
                WinkMusicLyricCropPart.this.G9().u5(MenuType.MUSIC, null);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onClickConfirmBtn() {
            WinkMusicLyricCropPart.this.X9().Z3();
            WinkMusicLyricCropPart.this.X9().L4();
            WinkMusicLyricCropPart.this.X9().t4(null, null);
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onIndicatorDragged(int videoClipPosition) {
            WinkMusicLyricCropPart.this.ea(videoClipPosition);
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onLyricClick(int positon) {
            WinkMusicLyricCropPart.this.da();
            WinkMusicLyricCropPart winkMusicLyricCropPart = WinkMusicLyricCropPart.this;
            winkMusicLyricCropPart.ia(positon, ((int) winkMusicLyricCropPart.X9().getVideoDurationMs()) + positon);
            WinkMusicLyricCropPart.this.X9().t4(Integer.valueOf(positon), Integer.valueOf(positon + ((int) WinkMusicLyricCropPart.this.X9().getVideoDurationMs())));
            WinkMusicLyricCropPart.this.X9().I4();
            WinkMusicLyricCropPart.this.ca();
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onMusicWaveMoveEnd(boolean isDragging) {
            if (!isDragging) {
                WinkMusicLyricCropPart.this.ca();
            } else {
                WinkMusicLyricCropPart.this.X9().I4();
                WinkMusicLyricCropPart.this.ca();
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onMusicWaveMoveStart() {
            WinkMusicLyricCropPart.this.da();
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onMusicWaveMoving(int startTimeInMs, int endTimeInMs) {
            WinkMusicLyricCropPart.this.ia(startTimeInMs, endTimeInMs);
            WinkMusicLyricCropPart.this.X9().t4(Integer.valueOf(startTimeInMs), Integer.valueOf(endTimeInMs));
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onResetMusicRangeToRecommend(int startTimeInMs) {
            WinkMusicLyricCropPart.this.X9().W3();
            int videoDurationMs = (int) (startTimeInMs + WinkMusicLyricCropPart.this.X9().getVideoDurationMs());
            WinkMusicLyricCropPart.this.ja(startTimeInMs);
            WinkMusicLyricCropPart.this.ia(startTimeInMs, videoDurationMs);
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void show(boolean show) {
            if (WinkMusicLyricCropPart.this.X9() != null) {
                WinkMusicLyricCropPart.this.X9().B4(show);
            }
        }
    }

    public WinkMusicLyricCropPart(@NotNull ViewModelStoreOwner owner) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MusicSourceViewModel>() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.WinkMusicLyricCropPart$musicSourceViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicSourceViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(WinkMusicLyricCropPart.this.getOwner()).get(MusicSourceViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(owner)\u2026rceViewModel::class.java)");
                return (MusicSourceViewModel) viewModel;
            }
        });
        this.musicSourceViewModel = lazy;
    }

    private final MutableLiveData<Long> J3() {
        return G9().B2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MusicSourceViewModel X9() {
        return (MusicSourceViewModel) this.musicSourceViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(WinkMusicLyricCropPart this$0, Long l3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (l3 != null) {
            this$0.ha((int) (l3.longValue() / 1000), (int) this$0.X9().getVideoDurationMs());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(WinkMusicLyricCropPart this$0, Long l3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (l3 != null) {
            this$0.ha((int) (l3.longValue() / 1000), (int) this$0.X9().getVideoDurationMs());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ca() {
        dr H9;
        if ((H9() instanceof WinkVideoTavCut) && (H9 = H9()) != null) {
            H9.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void da() {
        dr H9;
        if ((H9() instanceof WinkVideoTavCut) && (H9 = H9()) != null) {
            H9.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ea(int position) {
        if (H9() instanceof WinkVideoTavCut) {
            dr H9 = H9();
            if (H9 != null) {
                H9.seek(position);
            }
            dr H92 = H9();
            if (H92 != null) {
                H92.play();
            }
        }
    }

    private final void initViewModel() {
        if (X9() != null) {
            J3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkMusicLyricCropPart.aa(WinkMusicLyricCropPart.this, (Long) obj);
                }
            });
        }
        X9().Q2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMusicLyricCropPart.ba(WinkMusicLyricCropPart.this, (Long) obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return 0;
    }

    @NotNull
    /* renamed from: Y9, reason: from getter */
    public final ViewModelStoreOwner getOwner() {
        return this.owner;
    }

    public final void Z9() {
        d dVar;
        d dVar2 = this.lyricPanelDialog;
        boolean z16 = false;
        if (dVar2 != null && dVar2.isShowing()) {
            z16 = true;
        }
        if (z16 && (dVar = this.lyricPanelDialog) != null) {
            dVar.dismiss();
        }
    }

    public final void ga(@NotNull WinkEditorMusicInfo editorMusicInfo, @Nullable Integer savedMusicStartTimeInMs, long videoClipDurationInMs, boolean forceRefreshWaveView) {
        int s16;
        Intrinsics.checkNotNullParameter(editorMusicInfo, "editorMusicInfo");
        d dVar = this.lyricPanelDialog;
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
            d dVar2 = this.lyricPanelDialog;
            if (dVar2 != null) {
                dVar2.c0(editorMusicInfo, s16, (int) videoClipDurationInMs, this.musicWaveViewWidth, this.musicWaveViewHeight, forceRefreshWaveView);
            }
            ia(s16, (int) (s16 + videoClipDurationInMs));
            d dVar3 = this.lyricPanelDialog;
            if (dVar3 != null) {
                dVar3.show();
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(WinkMusicLyricEvent.class);
        return arrayList;
    }

    public final void ha(int videoClipProgressInMs, int videoClipDurationInMs) {
        d dVar;
        d dVar2 = this.lyricPanelDialog;
        boolean z16 = false;
        if (dVar2 != null && dVar2.isShowing()) {
            z16 = true;
        }
        if (z16 && (dVar = this.lyricPanelDialog) != null) {
            dVar.Z(videoClipProgressInMs, videoClipDurationInMs);
        }
    }

    public final void ia(int startTimeInMs, int endTimeInMs) {
        d dVar = this.lyricPanelDialog;
        if (dVar != null) {
            dVar.a0(startTimeInMs, endTimeInMs);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        initViewModel();
    }

    public final void ja(int musicProgressInMs) {
        d dVar;
        d dVar2 = this.lyricPanelDialog;
        boolean z16 = false;
        if (dVar2 != null && dVar2.isShowing()) {
            z16 = true;
        }
        if (z16 && (dVar = this.lyricPanelDialog) != null) {
            dVar.b0(musicProgressInMs);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        this.musicWaveViewWidth = ViewUtils.getScreenWidth();
        this.musicWaveViewHeight = getContext().getResources().getDimensionPixelSize(R.dimen.djc);
        d dVar = new d(getContext());
        dVar.setOnKeyListener(new a());
        this.lyricPanelDialog = dVar;
        Intrinsics.checkNotNull(dVar);
        dVar.Y(new b());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof WinkMusicLyricEvent) {
            WinkMusicLyricEvent winkMusicLyricEvent = (WinkMusicLyricEvent) event;
            ga(winkMusicLyricEvent.getEditorMusicInfo(), winkMusicLyricEvent.getSavedMusicStartTimeInMs(), winkMusicLyricEvent.getVideoClipDurationInMs(), winkMusicLyricEvent.getForceRefreshWaveView());
        }
    }
}
