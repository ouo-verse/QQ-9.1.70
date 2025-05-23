package com.tencent.qqnt.aio.translate.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.aio.translate.api.IAIOTranslateApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/translate/api/impl/AIOTranslateApiImpl;", "Lcom/tencent/qqnt/aio/translate/api/IAIOTranslateApi;", "()V", "openTranslatePage", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "translateContent", "", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class AIOTranslateApiImpl implements IAIOTranslateApi {
    @Override // com.tencent.qqnt.aio.translate.api.IAIOTranslateApi
    public void openTranslatePage(Activity activity, String translateContent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(translateContent, "translateContent");
        Intent intent = new Intent(activity, (Class<?>) TextPreviewTranslateActivity.class);
        intent.putExtra("TranslateText", translateContent);
        intent.putExtra("WhereAreYouFrom", "AIO_TEXTPREVIEW");
        activity.startActivityForResult(intent, -1);
    }
}
