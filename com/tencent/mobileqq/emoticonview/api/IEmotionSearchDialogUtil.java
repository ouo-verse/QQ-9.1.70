package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Pair;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&JL\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/api/IEmotionSearchDialogUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addCompositePicToCustom", "", "context", "Landroid/content/Context;", "searchItem", "Lcom/tencent/mobileqq/emosm/emosearch/EmotionSearchItem;", "searchWord", "", "filePath", "imageSize", "Landroid/util/Pair;", "", TextComponent.SpanStyle.TYPEFACE, "Landroid/graphics/Typeface;", "fetchEmosmKey", "app", "Lmqq/app/AppRuntime;", "e", "Lcom/tencent/mobileqq/data/Emoticon;", "sendCompositePic", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", QCircleLpReportDc010001.KEY_SUBTYPE, "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IEmotionSearchDialogUtil extends QRouteApi {
    void addCompositePicToCustom(@NotNull Context context, @NotNull EmotionSearchItem searchItem, @NotNull String searchWord, @NotNull String filePath, @NotNull Pair<Integer, Integer> imageSize, @NotNull Typeface typeface);

    void fetchEmosmKey(@Nullable AppRuntime app, @Nullable Emoticon e16);

    void sendCompositePic(@NotNull FragmentActivity activity, @NotNull EmotionSearchItem searchItem, @NotNull String searchWord, @NotNull String filePath, @NotNull Pair<Integer, Integer> imageSize, int subType, @NotNull Typeface typeface);
}
