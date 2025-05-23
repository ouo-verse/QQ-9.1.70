package com.tencent.mobileqq.vas.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0003\u0018\u0019\u001aJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&J:\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0014H&J\u001c\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasLiangNum;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "isEnable", "", "getSelfLiangId", "", "uin", "newId", "", "saveLiangNumId", "Lcom/tencent/mobileqq/vas/api/IVasLiangNum$b;", "l", "registerLiangIdChangedListener", "unregisterLiangIdChangedListener", "Landroid/view/View;", "view", "id", "viewHeight", "scene", "Lcom/tencent/mobileqq/vas/api/IVasLiangNum$c;", "setLiangNumDrawable", "Lkotlin/Pair;", "getPresettingWH", "a", "b", "c", "vas-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasLiangNum extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasLiangNum$a;", "", "", "id", "", "k", "vas-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface a {
        boolean k(int id5);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasLiangNum$b;", "", "", "onChanged", "vas-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface b {
        void onChanged();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasLiangNum$c;", "", "", "a", "vas-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface c {
        void a();
    }

    @NotNull
    Pair<Integer, Integer> getPresettingWH(@NotNull String uin);

    int getSelfLiangId();

    boolean isEnable();

    void registerLiangIdChangedListener(@NotNull b l3);

    void saveLiangNumId(@NotNull String uin, int newId);

    void setLiangNumDrawable(@NotNull View view, int id5, int viewHeight, @NotNull String uin, @NotNull String scene, @Nullable c l3);

    void unregisterLiangIdChangedListener(@NotNull b l3);
}
