package com.tencent.mm.ui.widget.pulldown;

import com.tencent.mm.ui.widget.pulldown.IBounceView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000b\u00c0\u0006\u0001"}, d2 = {"Lcom/tencent/mm/ui/widget/pulldown/IBounceCommon;", "", "addBounceOffsetChangedListener", "", "bounceOffsetChangedListener", "Lcom/tencent/mm/ui/widget/pulldown/IBounceView$BounceOffsetChangedListener;", "enableEnd2Start", "enable", "", "enableStart2End", "removeBounceOffsetChangedListener", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public interface IBounceCommon {
    void addBounceOffsetChangedListener(@Nullable IBounceView.BounceOffsetChangedListener bounceOffsetChangedListener);

    void enableEnd2Start(boolean enable);

    void enableStart2End(boolean enable);

    void removeBounceOffsetChangedListener(@Nullable IBounceView.BounceOffsetChangedListener bounceOffsetChangedListener);
}
