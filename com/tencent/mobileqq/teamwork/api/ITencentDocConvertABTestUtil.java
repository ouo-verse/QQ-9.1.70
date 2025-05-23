package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import java.util.List;
import ta1.h;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ITencentDocConvertABTestUtil extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(int i3);

        void b(ImageView imageView);
    }

    int calcHeightLayoutParam(AppInterface appInterface);

    void configureABTest(AppInterface appInterface, Activity activity, View view, TeamWorkFileImportInfo teamWorkFileImportInfo, a aVar);

    List<h> getWordingConfig();

    boolean hasConfig(TeamWorkFileImportInfo teamWorkFileImportInfo);

    boolean hasConfig(String str);
}
