package com.tencent.comic.api;

import android.content.Context;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IQQComicConfigApi extends QRouteApi {
    public static final String ACTION_GET_COMIC_CONFIG = "getComicConfig";
    public static final String ACTION_GET_IP_EXPRESSION_CONFIG = "getIpExpressionConfig";
    public static final String NAV_SWITCH_ANIMATION = "navSwitchAnimation";

    List<ComicCancelRedPointPopItemData> getCancelRedPointDialogDefaultData();

    int getCancelRedPointPopDayCount();

    int getReaderPreloadNum();

    boolean getSectionCommentMasterSwitch();

    int getSectionCommentNumVS();

    boolean isEnableCancelRedPointDataCache();

    boolean isEnableShowCancelRedPointDialog();

    boolean isIgnoreInteractiveControll();

    boolean isIgnoreReddotControll();

    boolean isMatched(String str);

    boolean isReaderEnablePreload();

    boolean isReaderEnablePreread();

    boolean launchIfMatched(String str, Context context, int i3, AppInterface appInterface);
}
