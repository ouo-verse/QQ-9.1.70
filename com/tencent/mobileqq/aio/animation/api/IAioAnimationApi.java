package com.tencent.mobileqq.aio.animation.api;

import android.content.Context;
import com.tencent.aio.data.AIOSession;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.animation.data.b;
import com.tencent.mobileqq.aio.animation.data.d;
import com.tencent.mobileqq.aio.animation.data.h;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u71.a;
import u71.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J6\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0002H&J\b\u0010\u001c\u001a\u00020\u0006H&J\b\u0010\u001d\u001a\u00020\u0006H&J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001eH&J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020!H&J\u0012\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010#H&J\u0012\u0010'\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010&H&\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/aio/animation/api/IAioAnimationApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "version", "", "url", "", "updateConfig", "updateResourceIfConfigChanged", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/animation/data/h;", "createContainer", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "", "Lcom/tencent/mobileqq/aio/animation/data/b;", TabPreloadItem.TAB_NAME_MESSAGE, "Lcom/tencent/mobileqq/aio/animation/data/d;", SessionDbHelper.SESSION_ID, "animContainer", "", "forceUpdateMsgSeq", "handleNewMsg", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "msgSeq", "setMsgHasRead", "cancelAll", "cleanup", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "convertMsgRecord", "Lcom/tencent/aio/data/AIOSession;", "convertSession", "Lu71/c;", "delegate", "setMsgDelegate", "Lu71/a;", "setTroopInfoDelegate", "aio_animation_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IAioAnimationApi extends QRouteApi {
    void cancelAll();

    void cleanup();

    @NotNull
    b convertMsgRecord(@NotNull MsgRecord msgRecord);

    @NotNull
    d convertSession(@NotNull AIOSession session);

    @NotNull
    h createContainer(@NotNull Context context);

    void handleNewMsg(@NotNull BaseQQAppInterface app, @NotNull List<? extends b> msgList, @NotNull d session, @NotNull h animContainer, boolean forceUpdateMsgSeq);

    void setMsgDelegate(@Nullable c delegate);

    void setMsgHasRead(@NotNull Contact contact, long msgSeq);

    void setTroopInfoDelegate(@Nullable a delegate);

    void updateConfig(long version, @NotNull String url);

    void updateResourceIfConfigChanged();
}
