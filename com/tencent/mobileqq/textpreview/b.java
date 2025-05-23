package com.tencent.mobileqq.textpreview;

import android.app.Activity;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.selectable.TextPreviewMenu;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.GestureActivityModule;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.qqnt.textpreview.PreviewTextContainerView;
import com.tencent.qqnt.textpreview.inject.e;
import com.tencent.qqnt.textpreview.inject.f;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes35.dex */
public class b implements com.tencent.qqnt.textpreview.inject.d {
    @Override // com.tencent.qqnt.textpreview.inject.d
    public com.tencent.qqnt.textpreview.inject.c<?> a() {
        return new TextPreviewMenu();
    }

    @Override // com.tencent.qqnt.textpreview.inject.d
    public void b(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        ReportController.o(appRuntime, str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
    }

    @Override // com.tencent.qqnt.textpreview.inject.d
    public boolean c() {
        return QQTheme.isNowThemeIsNight();
    }

    @Override // com.tencent.qqnt.textpreview.inject.d
    public PreviewTextContainerView d(Activity activity) {
        return new ContainerView(activity);
    }

    @Override // com.tencent.qqnt.textpreview.inject.d
    public List<com.tencent.qqnt.textpreview.inject.b> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TextPreviewVasBubble());
        return arrayList;
    }

    @Override // com.tencent.qqnt.textpreview.inject.d
    public e f() {
        return new c();
    }

    @Override // com.tencent.qqnt.textpreview.inject.d
    public void g(QBaseActivity qBaseActivity, FlingHandler flingHandler) {
        GestureActivityModule.setFlingHandler(qBaseActivity, flingHandler);
    }

    @Override // com.tencent.qqnt.textpreview.inject.d
    public f h() {
        return new d();
    }
}
