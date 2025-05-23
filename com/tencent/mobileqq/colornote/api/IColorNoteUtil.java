package com.tencent.mobileqq.colornote.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import ea1.c;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IColorNoteUtil extends QRouteApi {
    boolean checkPermission(Context context);

    ColorNote createRecentColorNote(ColorNote colorNote);

    void decorateColorNote(ColorNote colorNote);

    String getContentDescription(List<ColorNote> list);

    int getHistoryType(int i3);

    int getOriginType(int i3);

    String getWebViewIconUrl(String str);

    void hideColorNoteSmallScreen(Context context);

    boolean isAfterSyncMsg();

    boolean isDisableSwipeByUrl(String str);

    boolean isNeedNowNotify(ColorNote colorNote);

    boolean isRecentColorNote(ColorNote colorNote);

    boolean isUpcomingColorNote(ColorNote colorNote);

    boolean isUrlBlocked(String str);

    boolean isUrlShareEntranceBlocked(String str);

    boolean isUrlSmallScreenBlocked(String str);

    boolean isUseNewColorNoteStyle();

    c loadConfig();

    void notifyUpcoming(Context context, ColorNote colorNote);

    boolean propertyEquals(String str, String str2);

    void requestPermission(Context context);

    void sendUpdateSmallScreenStateBroadcast(Context context, int i3, boolean z16);

    void setAfterSyncMsg(boolean z16);

    void setAppOnForeground(AppRuntime appRuntime, boolean z16);

    void showFullDialog(Context context);

    void showList(Context context, boolean z16);

    void showListFromAddTodo(Context context, boolean z16);

    void startColorNoteSettingPage(Context context, Bundle bundle);
}
