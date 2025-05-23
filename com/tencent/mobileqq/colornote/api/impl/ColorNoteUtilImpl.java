package com.tencent.mobileqq.colornote.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import ea1.c;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ColorNoteUtilImpl implements IColorNoteUtil {
    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public boolean checkPermission(Context context) {
        return com.tencent.mobileqq.colornote.smallscreen.b.d(context);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public ColorNote createRecentColorNote(ColorNote colorNote) {
        return com.tencent.mobileqq.colornote.data.a.c(colorNote);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public void decorateColorNote(ColorNote colorNote) {
        com.tencent.mobileqq.colornote.data.a.d(colorNote);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public String getContentDescription(List<ColorNote> list) {
        return com.tencent.mobileqq.colornote.data.a.h(list);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public int getHistoryType(int i3) {
        return com.tencent.mobileqq.colornote.data.a.i(i3);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public int getOriginType(int i3) {
        return com.tencent.mobileqq.colornote.data.a.k(i3);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public String getWebViewIconUrl(String str) {
        return com.tencent.mobileqq.colornote.data.a.m(str);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public void hideColorNoteSmallScreen(Context context) {
        ColorNoteSmallScreenUtil.h(context);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public boolean isAfterSyncMsg() {
        return ColorNoteSmallScreenUtil.i();
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public boolean isDisableSwipeByUrl(String str) {
        return com.tencent.mobileqq.colornote.data.a.s(str);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public boolean isNeedNowNotify(ColorNote colorNote) {
        return com.tencent.mobileqq.colornote.data.a.u(colorNote);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public boolean isRecentColorNote(ColorNote colorNote) {
        return com.tencent.mobileqq.colornote.data.a.w(colorNote);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public boolean isUpcomingColorNote(ColorNote colorNote) {
        return com.tencent.mobileqq.colornote.data.a.x(colorNote);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public boolean isUrlBlocked(String str) {
        return com.tencent.mobileqq.colornote.data.a.y(str);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public boolean isUrlShareEntranceBlocked(String str) {
        return com.tencent.mobileqq.colornote.data.a.z(str);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public boolean isUrlSmallScreenBlocked(String str) {
        return com.tencent.mobileqq.colornote.data.a.A(str);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public boolean isUseNewColorNoteStyle() {
        return ia1.a.c();
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public c loadConfig() {
        return ColorNoteRecentConfigProcessor.a();
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public void notifyUpcoming(Context context, ColorNote colorNote) {
        com.tencent.mobileqq.colornote.data.a.C(context, colorNote);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public boolean propertyEquals(String str, String str2) {
        return com.tencent.mobileqq.colornote.data.a.D(str, str2);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public void requestPermission(Context context) {
        com.tencent.mobileqq.colornote.smallscreen.b.f(context);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public void sendUpdateSmallScreenStateBroadcast(Context context, int i3, boolean z16) {
        ColorNoteSmallScreenUtil.m(context, i3, z16);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public void setAfterSyncMsg(boolean z16) {
        ColorNoteSmallScreenUtil.n(z16);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public void setAppOnForeground(AppRuntime appRuntime, boolean z16) {
        ColorNoteSmallScreenUtil.o(appRuntime, z16);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public void showFullDialog(Context context) {
        com.tencent.mobileqq.colornote.data.a.E(context);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public void showList(Context context, boolean z16) {
        ColorNoteSmallScreenUtil.r(context, z16);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public void showListFromAddTodo(Context context, boolean z16) {
        ColorNoteSmallScreenUtil.s(context, z16);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteUtil
    public void startColorNoteSettingPage(Context context, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("start_from", 2);
        ColorNoteSettingFragment.vh(context, ColorNoteSettingFragment.class, bundle);
    }
}
