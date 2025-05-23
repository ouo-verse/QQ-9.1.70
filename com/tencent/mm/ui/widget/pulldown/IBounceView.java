package com.tencent.mm.ui.widget.pulldown;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001:\u0001\u001fJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u001c\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u000e\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0003H&J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\tH&J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0003H&J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0003H&J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0003H&J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0003H&J\u0012\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006 \u00c0\u0006\u0001"}, d2 = {"Lcom/tencent/mm/ui/widget/pulldown/IBounceView;", "Lcom/tencent/mm/ui/widget/pulldown/IBounceCommon;", "getOffset", "", "getView", "Landroid/view/View;", "initBounce", "", "isBounceEnabled", "", "setAtEndCallback", "callback", "Lcom/tencent/mm/ui/widget/pulldown/AtEndCallback;", "target", "setAtStartCallback", "Lcom/tencent/mm/ui/widget/pulldown/AtStartCallback;", "setBg", "drawable", "Landroid/graphics/drawable/Drawable;", "setBgColor", "color", "setBounceEnabled", NodeProps.ENABLED, "setEnd2StartBg", "setEnd2StartBgColor", "setEnd2StartBgColorByNavigationBar", "setStart2EndBg", "setStart2EndBgColor", "setStart2EndBgColorByActionBar", "setView", "contentView", "BounceOffsetChangedListener", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public interface IBounceView extends IBounceCommon {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\b\u00c0\u0006\u0001"}, d2 = {"Lcom/tencent/mm/ui/widget/pulldown/IBounceView$BounceOffsetChangedListener;", "", "onBounceOffsetChanged", "", "offset", "", "onBounceStart", "direction", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public interface BounceOffsetChangedListener {
        void onBounceOffsetChanged(int offset);

        void onBounceStart(int direction);
    }

    int getOffset();

    @NotNull
    View getView();

    void initBounce();

    boolean isBounceEnabled();

    void setAtEndCallback(@Nullable AtEndCallback callback, @Nullable View target);

    void setAtStartCallback(@Nullable AtStartCallback callback, @Nullable View target);

    void setBg(@NotNull Drawable drawable);

    void setBgColor(int color);

    void setBounceEnabled(boolean enabled);

    void setEnd2StartBg(@NotNull Drawable drawable);

    void setEnd2StartBgColor(int color);

    void setEnd2StartBgColorByNavigationBar(int color);

    void setStart2EndBg(@NotNull Drawable drawable);

    void setStart2EndBgColor(int color);

    void setStart2EndBgColorByActionBar(int color);

    void setView(@Nullable View contentView);
}
