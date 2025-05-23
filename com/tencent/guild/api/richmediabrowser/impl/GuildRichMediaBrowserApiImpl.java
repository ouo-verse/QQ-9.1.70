package com.tencent.guild.api.richmediabrowser.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.guild.api.richmediabrowser.IGuildRichMediaBrowserApi;
import com.tencent.mobileqq.guild.temp.api.IGuildGalleryApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\\\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011H\u0016JX\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011H\u0016J \u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\u001c\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/guild/api/richmediabrowser/impl/GuildRichMediaBrowserApiImpl;", "Lcom/tencent/guild/api/richmediabrowser/IGuildRichMediaBrowserApi;", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Landroid/view/View;", "view", "", "playPosition", "", "isMute", "isOneItemOnly", "Landroid/os/Bundle;", "extraInfo", "", "aioRichMediaList", "", "enterVideoPreview", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "isOnePic", "enterImagePreview", "appRuntime", "enterFileBrowser", "msgRecordList", "onMsgRevoke", "<init>", "()V", "Companion", "a", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildRichMediaBrowserApiImpl implements IGuildRichMediaBrowserApi {

    @NotNull
    public static final String TAG = "GuildRichMediaBrowserApiImpl";

    @Override // com.tencent.guild.api.richmediabrowser.IGuildRichMediaBrowserApi
    public void enterFileBrowser(@NotNull AppRuntime appRuntime, @NotNull Context context, @NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ((IGuildGalleryApi) QRoute.api(IGuildGalleryApi.class)).enterFileBrowser(appRuntime, context, msgRecord);
    }

    @Override // com.tencent.guild.api.richmediabrowser.IGuildRichMediaBrowserApi
    public void enterImagePreview(@NotNull AppRuntime app, @Nullable Context context, @Nullable View view, @NotNull MsgRecord msgRecord, @Nullable PicElement picElement, boolean isOnePic, @Nullable Bundle extraInfo, @Nullable List<MsgRecord> aioRichMediaList) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ((IGuildGalleryApi) QRoute.api(IGuildGalleryApi.class)).enterImagePreview(app, context, view, msgRecord, picElement, isOnePic, extraInfo, aioRichMediaList);
    }

    @Override // com.tencent.guild.api.richmediabrowser.IGuildRichMediaBrowserApi
    public void enterVideoPreview(@NotNull AppRuntime app, @NotNull Context context, @NotNull MsgRecord msgRecord, @Nullable View view, long playPosition, boolean isMute, boolean isOneItemOnly, @Nullable Bundle extraInfo, @Nullable List<MsgRecord> aioRichMediaList) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ((IGuildGalleryApi) QRoute.api(IGuildGalleryApi.class)).enterVideoPreview(app, context, msgRecord, view, playPosition, isMute, isOneItemOnly, extraInfo, aioRichMediaList);
    }

    @Override // com.tencent.guild.api.richmediabrowser.IGuildRichMediaBrowserApi
    public void onMsgRevoke(@NotNull List<MsgRecord> msgRecordList) {
        Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        ((IGuildGalleryApi) QRoute.api(IGuildGalleryApi.class)).onMsgRevoke(msgRecordList);
    }
}
