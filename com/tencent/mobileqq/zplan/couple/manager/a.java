package com.tencent.mobileqq.zplan.couple.manager;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.show.MsgData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J8\u0010\u0010\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0011\u001a\u00020\u000fH&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/couple/manager/a;", "", "Lcom/tencent/mobileqq/zplan/show/b;", "inputInfo", "", "c", "(Lcom/tencent/mobileqq/zplan/show/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "textureView", "headPointEventData", "", "a", "b", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.zplan.couple.manager.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C9163a {
        public static /* synthetic */ Object a(a aVar, MsgData msgData, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    msgData = null;
                }
                return aVar.c(msgData, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBubbleEventData");
        }
    }

    void a(@Nullable Context context, @NotNull Activity activity, @Nullable View rootView, @Nullable View textureView, @Nullable String headPointEventData);

    void b();

    @Nullable
    Object c(@Nullable MsgData msgData, @NotNull Continuation<? super String> continuation);
}
