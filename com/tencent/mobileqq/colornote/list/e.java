package com.tencent.mobileqq.colornote.list;

import android.view.View;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface e extends View.OnClickListener, h {
    void Pf(AppRuntime appRuntime, boolean z16, int i3, int i16);

    View getRoot();

    boolean isShowing();

    void onPostThemeChanged();

    void refresh();

    void refresh(List<ColorNote> list);

    void v7(boolean z16);
}
