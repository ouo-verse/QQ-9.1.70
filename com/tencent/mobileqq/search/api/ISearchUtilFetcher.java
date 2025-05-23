package com.tencent.mobileqq.search.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.WorkerThread;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.search.SearchHistoryEntity;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.model.z;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISearchUtilFetcher extends QRouteApi {
    void fTSEntitySearchActivityLaunch(Context context, String str, int i3);

    void fTSEntitySearchDetailActivityLaunch(Context context, String str, String str2, CharSequence charSequence, List list, int i3, String str3, int i16, int i17, int i18);

    Class getActiveEntitySearchActivityClass();

    Drawable getFaceBitmap(IFaceDecoder iFaceDecoder, String str, int i3);

    Manager getLocalSearchManager(AppInterface appInterface);

    boolean getSearchUtilIsContentFromHotWord();

    Class getUniteSearchActivityClass();

    int getUniteSearchActivityFromForHistoryCode();

    void handleFeatureJump(Context context, int i3, int i16);

    boolean isEntityGroup(long j3);

    boolean isGuildModel(y yVar);

    boolean isRobotUin(AppRuntime appRuntime, String str);

    boolean isTroopModel(y yVar);

    boolean isUniteSearchActivity(Context context);

    boolean isValidGroupMask(long j3);

    void launchActiveEntitySearchActivity(boolean z16, Context context, String str, String str2, long[] jArr);

    @WorkerThread
    void loadSearchHistory(Function1<List<SearchHistoryEntity>, Void> function1);

    void mobileReportAction(String str, String str2, String str3, String str4, String str5, int i3, int i16, long j3);

    void openRobotProfileCard(Context context, String str, String str2);

    void openTroopInfoActivity(Context context, Bundle bundle, int i3);

    void publicFragmentStart(Context context, Intent intent, Class cls);

    @WorkerThread
    boolean removeHistoryById(long j3);

    void report(Context context, String str, String str2);

    void report(String str, String str2, int i3, int i16, String... strArr);

    void report(String str, String str2, String str3, int i3, int i16, String... strArr);

    void reportContactResultItemClick(z zVar, View view);

    void reportJumpToAIOorProfile(String str, int i3, View view, boolean z16);

    void reportSearchResultClickItem(z zVar);

    void reportSearchResultClickMore(List<y> list, String str);

    void saveSearchHistory(AppInterface appInterface, String str, String str2, String str3, int i3);

    void saveSearchHistory(AppInterface appInterface, String str, String str2, String str3, int i3, String str4);

    void searchEnginePerfReporterAddParams(String str, String str2, Object obj);

    void searchEnginePerfReporterEndStep(String str, String str2);

    void searchEnginePerfReporterStartStep(String str, String str2);

    void selectContactResult(View view, z zVar);

    ArrayList<String> splitSearchKeyword(String str);

    void startProfileCardActivity(Activity activity, SearchResultItem searchResultItem, AppInterface appInterface, boolean z16, int i3);

    void updateItemUsed(AppInterface appInterface, String str, String str2, String str3, int i3);
}
