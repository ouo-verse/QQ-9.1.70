package com.tencent.state.square.detail;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.state.map.MapItem;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/detail/DetailCommonListener;", "", "goToMall", "", "goToProfile", "view", "Landroid/view/View;", "data", "Lcom/tencent/state/map/MapItem;", "goToSmallHome", "hideSquareAvatar", "isClickAvatar", "", "e", "Landroid/view/MotionEvent;", "isEditor", "onBackClick", "onMenuClick", "onSharePosterClick", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface DetailCommonListener {
    void goToMall();

    void goToProfile(View view, MapItem data);

    void goToSmallHome();

    void hideSquareAvatar();

    boolean isClickAvatar(MotionEvent e16, boolean isEditor);

    void onBackClick();

    void onMenuClick();

    void onSharePosterClick();
}
