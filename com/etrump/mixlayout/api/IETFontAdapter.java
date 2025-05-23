package com.etrump.mixlayout.api;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.CharacterStyle;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.b;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u0000 '2\u00020\u0001:\u0001'J6\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J@\u0010\u0010\u001a\u00020\u00072\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&J\u0012\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013H&J\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013H&J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0013H&J\u0012\u0010!\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013H&J\"\u0010\"\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013H&J>\u0010#\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u00132\u0006\u0010&\u001a\u00020\u0017H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006("}, d2 = {"Lcom/etrump/mixlayout/api/IETFontAdapter;", "", "sysEmotcationHead", "", "getSysEmotcationHead", "()C", CanvasView.ACTION_DRAWIMAGE, "", PM.CANVAS, "Landroid/graphics/Canvas;", HippyTKDListViewAdapter.X, "", "y", "obj", "paint", "Landroid/graphics/Paint;", "drawSignatureSpan", "mSpans", "Ljava/util/ArrayList;", "Landroid/text/style/CharacterStyle;", "mFont", "Lcom/etrump/mixlayout/ETFont;", "mSignSpanIndex", "", "getDIYFontImage", "", "uuid", "getSpanHeight", TtmlNode.TAG_SPAN, "getSpanWidth", "isInstanceOfEmoticonSpan", "", "mSpan", "isInstanceOfSignatureActionSpan", "setSignatureActionSpanData", "systemDrawSpan", "left", "top", "fontSize", "Companion", "vas_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes2.dex */
public interface IETFontAdapter {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/etrump/mixlayout/api/IETFontAdapter$Companion;", "", "Lcom/etrump/mixlayout/b;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/etrump/mixlayout/b;", "getInstance", "()Lcom/etrump/mixlayout/b;", "<init>", "()V", "vas_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final b instance = new b();

        Companion() {
        }

        @NotNull
        public final b getInstance() {
            return instance;
        }
    }

    void drawImage(@Nullable Canvas canvas, float x16, float y16, @Nullable Object obj, @Nullable Paint paint);

    void drawSignatureSpan(@Nullable ArrayList<CharacterStyle> mSpans, @Nullable ETFont mFont, @Nullable Paint paint, int mSignSpanIndex, @Nullable Canvas canvas);

    @Nullable
    String getDIYFontImage(@Nullable String uuid);

    int getSpanHeight(@Nullable CharacterStyle span);

    int getSpanWidth(@Nullable CharacterStyle span);

    char getSysEmotcationHead();

    boolean isInstanceOfEmoticonSpan(@Nullable CharacterStyle mSpan);

    boolean isInstanceOfSignatureActionSpan(@Nullable CharacterStyle span);

    void setSignatureActionSpanData(int x16, int y16, @Nullable CharacterStyle span);

    void systemDrawSpan(@Nullable Canvas canvas, int left, int top, @Nullable Paint paint, @Nullable CharacterStyle mSpan, int fontSize);
}
