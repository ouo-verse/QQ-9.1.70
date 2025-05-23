package com.tencent.mobileqq.zplan.meme.api;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.model.MemeResult;
import org.json.JSONObject;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IApolloBrickPlayer extends QRouteApi {

    /* loaded from: classes21.dex */
    public interface a {
        void a(boolean z16, @Nullable String str, @NonNull MemeAction memeAction, MemeResult memeResult);
    }

    void destroy();

    View getView();

    void pause();

    void resume();

    void setAction(MemeAction memeAction, JSONObject jSONObject);

    void setGetFrameCallback(a aVar);

    void setLoadingView(Drawable drawable);

    void setParams(com.tencent.mobileqq.zplan.meme.a aVar);

    void start();
}
