package com.tencent.state.library.calendar;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.mmkv.IMMKV;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bJ\u0010\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004J\b\u0010\u0011\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/library/calendar/CalendarEntryManager;", "", "()V", "entryConfig", "Lcom/tencent/state/library/calendar/CalendarEntryConfig;", "entryView", "Landroid/view/View;", "redDotView", "initEntryView", "", NodeProps.ON_CLICK, "Lkotlin/Function0;", "openFocusCalendarPage", "context", "Landroid/content/Context;", "setEntryConfig", DownloadInfo.spKey_Config, "updateEntryVisibility", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class CalendarEntryManager {
    private CalendarEntryConfig entryConfig = new CalendarEntryConfig(false, null, null, 7, null);
    private View entryView;
    private View redDotView;

    private final void updateEntryVisibility() {
        View view = this.entryView;
        if (view != null) {
            ViewExtensionsKt.setVisibility(view, this.entryConfig.isShowEntry());
        }
        View view2 = this.redDotView;
        if (view2 != null) {
            ViewExtensionsKt.setVisibility(view2, this.entryConfig.isShowEntry() && !IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Calendar.KEY_CALENDAR_RED_DOT_HAS_SHOWN, false, null, false, 12, null));
        }
    }

    public final void initEntryView(final View entryView, View redDotView, final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.entryView = entryView;
        this.redDotView = redDotView;
        if (entryView != null) {
            entryView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.calendar.CalendarEntryManager$initEntryView$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CalendarEntryManager.this.openFocusCalendarPage(entryView.getContext());
                    onClick.invoke();
                }
            });
        }
        updateEntryVisibility();
    }

    public final void setEntryConfig(CalendarEntryConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.entryConfig = config;
        updateEntryVisibility();
    }

    public final void openFocusCalendarPage(Context context) {
        if (context != null) {
            View view = this.redDotView;
            if (view != null) {
                ViewExtensionsKt.setVisibility(view, false);
            }
            IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Calendar.KEY_CALENDAR_RED_DOT_HAS_SHOWN, true, null, false, 12, null);
            SquareBaseKt.getSquareRouter().routeLink(context, new EntranceLink(this.entryConfig.getEntryUrl(), 2));
        }
    }
}
