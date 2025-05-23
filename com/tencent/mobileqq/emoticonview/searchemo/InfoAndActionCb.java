package com.tencent.mobileqq.emoticonview.searchemo;

import android.graphics.Typeface;
import android.view.View;
import com.tencent.mobileqq.emoticonview.HotPicSearchEmoticonInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0011\u001a\u00020\u0007H&J\u001a\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/InfoAndActionCb;", "", "loadingStatus", "", "getLoadingStatus", "()I", "clickCompositeTitle", "", "clickEmoticonSetting", "clickEmoticonShop", "clickFooterView", "isComposite", "", "getCurSearchWords", "", "getTypeface", "Landroid/graphics/Typeface;", "sendEmotionHappened", "showAddCustomPopup", "view", "Landroid/view/View;", "emoticonInfo", "Lcom/tencent/mobileqq/emoticonview/HotPicSearchEmoticonInfo;", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public interface InfoAndActionCb {
    void clickCompositeTitle();

    void clickEmoticonSetting();

    void clickEmoticonShop();

    void clickFooterView(boolean isComposite);

    @NotNull
    CharSequence getCurSearchWords();

    int getLoadingStatus();

    @Nullable
    Typeface getTypeface();

    void sendEmotionHappened();

    void showAddCustomPopup(@NotNull View view, @Nullable HotPicSearchEmoticonInfo emoticonInfo);
}
