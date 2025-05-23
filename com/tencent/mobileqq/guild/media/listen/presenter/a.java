package com.tencent.mobileqq.guild.media.listen.presenter;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0012\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\tH&J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\tH&J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\tH&J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH&J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\tH&J\b\u0010\u001a\u001a\u00020\u0002H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/listen/presenter/a;", "", "", "a", "e", "", "curPtsMS", "durationMS", "g", "", "from", "d", "", "needShow", "i", WidgetCacheConstellationData.NUM, "b", ViewStickEventHelper.IS_SHOW, "f", "res", UIJsPlugin.EVENT_SHOW_TOAST, "context", "btnStr", "j", "operate", tl.h.F, "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface a {
    void a();

    void b(int num);

    void c();

    void d(int from);

    void e();

    void f(int isShow);

    void g(long curPtsMS, long durationMS);

    void h(int operate);

    void i(boolean needShow);

    void j(int context, int btnStr);

    void showToast(int res);
}
