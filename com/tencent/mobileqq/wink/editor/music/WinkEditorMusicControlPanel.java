package com.tencent.mobileqq.wink.editor.music;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicPanel;
import com.tencent.mobileqq.wink.editor.music.lyric.d;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b<\u0010=B\u001b\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u0012\b\u0010?\u001a\u0004\u0018\u00010>\u00a2\u0006\u0004\b<\u0010@B#\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u0012\b\u0010?\u001a\u0004\u0018\u00010>\u0012\u0006\u0010A\u001a\u00020\u0012\u00a2\u0006\u0004\b<\u0010BJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\f\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tJ\u0016\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\tJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J/\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0004J\u0016\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012J\u0016\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012J\u000e\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0012J\u0010\u0010%\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010$J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0002J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0002J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0002J\u000e\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0002J\u000e\u0010,\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.R\u0018\u00103\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u00102R\u0018\u00106\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u00105R\u0016\u00108\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00107R\u0016\u00109\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00107\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicControlPanel;", "Landroid/widget/FrameLayout;", "", "enable", "", "setEnableMusic", "Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicPanel$c;", "callback", "setMusicListOperationCallback", "", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "musicInfoList", "f", "Lcom/tencent/mobileqq/wink/editor/music/ax;", "categoryList", "e", ViewStickEventHelper.IS_SHOW, "c", "", "position", "b", "editorMusicInfo", "savedMusicStartTimeInMs", "", "videoClipDurationInMs", "forceRefreshWaveView", "d", "(Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;Ljava/lang/Integer;JZ)V", "a", "startTimeInMs", "endTimeInMs", tl.h.F, "videoClipProgressInMs", "g", "musicProgressInMs", "i", "Lcom/tencent/mobileqq/wink/editor/music/lyric/d$d;", "setMusicLyricOperationCallback", NodeProps.VISIBLE, "setOperatePanelVisible", "setClipEntranceVisible", "setCollectEntranceVisible", "isCollect", "setCollectEntrance", "setMusicDisableEnable", "setMusicEnableClear", "", "source", "setMusicLibrarySource", "Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicPanel;", "Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicPanel;", "musicPanel", "Lcom/tencent/mobileqq/wink/editor/music/lyric/d;", "Lcom/tencent/mobileqq/wink/editor/music/lyric/d;", "lyricPanelDialog", "I", "musicWaveViewWidth", "musicWaveViewHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorMusicControlPanel extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkEditorMusicPanel musicPanel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.music.lyric.d lyricPanelDialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int musicWaveViewWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int musicWaveViewHeight;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f320661i;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/music/WinkEditorMusicControlPanel$a", "Landroid/content/DialogInterface$OnKeyListener;", "Landroid/content/DialogInterface;", "dialog", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements DialogInterface.OnKeyListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(@Nullable DialogInterface dialog, int keyCode, @Nullable KeyEvent event) {
            if (keyCode == 4) {
                WinkEditorMusicControlPanel.this.a();
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorMusicControlPanel(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f320661i = new LinkedHashMap();
        this.musicWaveViewWidth = ViewUtils.getScreenWidth();
        this.musicWaveViewHeight = getContext().getResources().getDimensionPixelSize(R.dimen.djc);
        WinkEditorMusicPanel winkEditorMusicPanel = new WinkEditorMusicPanel(getContext());
        this.musicPanel = winkEditorMusicPanel;
        addView(winkEditorMusicPanel, new FrameLayout.LayoutParams(-1, -1));
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar = new com.tencent.mobileqq.wink.editor.music.lyric.d(getContext());
        dVar.setOnKeyListener(new a());
        this.lyricPanelDialog = dVar;
    }

    public final void a() {
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar;
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar2 = this.lyricPanelDialog;
        boolean z16 = false;
        if (dVar2 != null && dVar2.isShowing()) {
            z16 = true;
        }
        if (z16 && (dVar = this.lyricPanelDialog) != null) {
            dVar.dismiss();
        }
    }

    public final void b(int position) {
        WinkEditorMusicPanel winkEditorMusicPanel = this.musicPanel;
        if (winkEditorMusicPanel != null) {
            winkEditorMusicPanel.g(position);
        }
    }

    public final void c(boolean isShow) {
        WinkEditorMusicPanel winkEditorMusicPanel = this.musicPanel;
        if (winkEditorMusicPanel != null) {
            winkEditorMusicPanel.h(isShow);
        }
    }

    public final void d(@NotNull WinkEditorMusicInfo editorMusicInfo, @Nullable Integer savedMusicStartTimeInMs, long videoClipDurationInMs, boolean forceRefreshWaveView) {
        int s16;
        Intrinsics.checkNotNullParameter(editorMusicInfo, "editorMusicInfo");
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
            h(s16, (int) (s16 + videoClipDurationInMs));
            com.tencent.mobileqq.wink.editor.music.lyric.d dVar3 = this.lyricPanelDialog;
            if (dVar3 != null) {
                dVar3.show();
            }
        }
    }

    public final void e(@NotNull List<? extends ax> categoryList) {
        Intrinsics.checkNotNullParameter(categoryList, "categoryList");
        WinkEditorMusicPanel winkEditorMusicPanel = this.musicPanel;
        if (winkEditorMusicPanel != null) {
            winkEditorMusicPanel.i(categoryList);
        }
    }

    public final void f(@NotNull List<? extends WinkEditorMusicInfo> musicInfoList) {
        Intrinsics.checkNotNullParameter(musicInfoList, "musicInfoList");
        WinkEditorMusicPanel winkEditorMusicPanel = this.musicPanel;
        if (winkEditorMusicPanel != null) {
            winkEditorMusicPanel.j(musicInfoList);
        }
    }

    public final void g(int videoClipProgressInMs, int videoClipDurationInMs) {
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar;
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar2 = this.lyricPanelDialog;
        boolean z16 = false;
        if (dVar2 != null && dVar2.isShowing()) {
            z16 = true;
        }
        if (z16 && (dVar = this.lyricPanelDialog) != null) {
            dVar.Z(videoClipProgressInMs, videoClipDurationInMs);
        }
    }

    public final void h(int startTimeInMs, int endTimeInMs) {
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar = this.lyricPanelDialog;
        if (dVar != null) {
            dVar.a0(startTimeInMs, endTimeInMs);
        }
    }

    public final void i(int musicProgressInMs) {
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar;
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar2 = this.lyricPanelDialog;
        boolean z16 = false;
        if (dVar2 != null && dVar2.isShowing()) {
            z16 = true;
        }
        if (z16 && (dVar = this.lyricPanelDialog) != null) {
            dVar.b0(musicProgressInMs);
        }
    }

    public final void setClipEntranceVisible(boolean visible) {
        WinkEditorMusicPanel winkEditorMusicPanel = this.musicPanel;
        if (winkEditorMusicPanel != null) {
            winkEditorMusicPanel.setClipEntranceVisible(visible);
        }
    }

    public final void setCollectEntrance(boolean isCollect) {
        WinkEditorMusicPanel winkEditorMusicPanel = this.musicPanel;
        if (winkEditorMusicPanel != null) {
            winkEditorMusicPanel.setCollectEntrance(isCollect);
        }
    }

    public final void setCollectEntranceVisible(boolean visible) {
        WinkEditorMusicPanel winkEditorMusicPanel = this.musicPanel;
        if (winkEditorMusicPanel != null) {
            winkEditorMusicPanel.setCollectEntranceVisible(visible);
        }
    }

    public final void setEnableMusic(boolean enable) {
        WinkEditorMusicPanel winkEditorMusicPanel = this.musicPanel;
        if (winkEditorMusicPanel != null) {
            winkEditorMusicPanel.setEnableBgm(enable);
        }
    }

    public final void setMusicDisableEnable(boolean enable) {
        WinkEditorMusicPanel winkEditorMusicPanel = this.musicPanel;
        if (winkEditorMusicPanel != null) {
            winkEditorMusicPanel.setMusicDisableEnable(enable);
        }
    }

    public final void setMusicEnableClear(boolean enable) {
        WinkEditorMusicPanel winkEditorMusicPanel = this.musicPanel;
        if (winkEditorMusicPanel != null) {
            winkEditorMusicPanel.setMusicEnableClear(enable);
        }
    }

    public final void setMusicLibrarySource(@NotNull String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        WinkEditorMusicPanel winkEditorMusicPanel = this.musicPanel;
        if (winkEditorMusicPanel != null) {
            winkEditorMusicPanel.setMusicLibrarySource(source);
        }
    }

    public final void setMusicListOperationCallback(@Nullable WinkEditorMusicPanel.c callback) {
        WinkEditorMusicPanel winkEditorMusicPanel = this.musicPanel;
        if (winkEditorMusicPanel != null) {
            winkEditorMusicPanel.setOperationCallback(callback);
        }
    }

    public final void setMusicLyricOperationCallback(@Nullable d.InterfaceC9031d callback) {
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar = this.lyricPanelDialog;
        if (dVar != null) {
            dVar.Y(callback);
        }
    }

    public final void setOperatePanelVisible(boolean visible) {
        WinkEditorMusicPanel winkEditorMusicPanel = this.musicPanel;
        if (winkEditorMusicPanel != null) {
            winkEditorMusicPanel.setOperatePanelVisible(visible);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorMusicControlPanel(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f320661i = new LinkedHashMap();
        this.musicWaveViewWidth = ViewUtils.getScreenWidth();
        this.musicWaveViewHeight = getContext().getResources().getDimensionPixelSize(R.dimen.djc);
        WinkEditorMusicPanel winkEditorMusicPanel = new WinkEditorMusicPanel(getContext());
        this.musicPanel = winkEditorMusicPanel;
        addView(winkEditorMusicPanel, new FrameLayout.LayoutParams(-1, -1));
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar = new com.tencent.mobileqq.wink.editor.music.lyric.d(getContext());
        dVar.setOnKeyListener(new a());
        this.lyricPanelDialog = dVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorMusicControlPanel(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f320661i = new LinkedHashMap();
        this.musicWaveViewWidth = ViewUtils.getScreenWidth();
        this.musicWaveViewHeight = getContext().getResources().getDimensionPixelSize(R.dimen.djc);
        WinkEditorMusicPanel winkEditorMusicPanel = new WinkEditorMusicPanel(getContext());
        this.musicPanel = winkEditorMusicPanel;
        addView(winkEditorMusicPanel, new FrameLayout.LayoutParams(-1, -1));
        com.tencent.mobileqq.wink.editor.music.lyric.d dVar = new com.tencent.mobileqq.wink.editor.music.lyric.d(getContext());
        dVar.setOnKeyListener(new a());
        this.lyricPanelDialog = dVar;
    }
}
