package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import android.os.Parcelable;
import android.widget.Adapter;
import android.widget.ImageButton;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.qqemoticon.api.IPanelListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IEmoticonInfoService extends QRouteApi {
    void addToCommonUsed(IEmoticonMainPanelApp iEmoticonMainPanelApp, Parcelable parcelable, int i3, int i16);

    void addToCommonUsed(AppRuntime appRuntime, Parcelable parcelable, int i3, int i16);

    IEmoticonPanelLinearLayoutHelper createEmoticonPanelLayoutHelper(Context context, IPanelListener iPanelListener);

    int getAddedHeight();

    <T> List<T> getCommonUsedSystemEmojiPanelData(IEmoticonMainPanelApp iEmoticonMainPanelApp, int i3, boolean z16);

    ImageButton getDeleteImageBtn(EmotionPanelListView.PullAndFastScrollListener pullAndFastScrollListener);

    <T> List<T> getEmoticonList(IEmoticonMainPanelApp iEmoticonMainPanelApp, int i3, int i16);

    JSONObject getJSONFromLocal(AppRuntime appRuntime, boolean z16);

    boolean isSmallEmotionDownloadedAdapter(Adapter adapter);

    void saveSystemEmojiInfoToFile(IEmoticonMainPanelApp iEmoticonMainPanelApp);
}
