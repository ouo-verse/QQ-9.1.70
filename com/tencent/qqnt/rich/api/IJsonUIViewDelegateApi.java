package com.tencent.qqnt.rich.api;

import com.tencent.android.androidbypass.richui.view.i;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/rich/api/IJsonUIViewDelegateApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/android/androidbypass/richui/view/i;", "getViewFactory", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IJsonUIViewDelegateApi extends QRouteApi {
    @NotNull
    i getViewFactory();
}
