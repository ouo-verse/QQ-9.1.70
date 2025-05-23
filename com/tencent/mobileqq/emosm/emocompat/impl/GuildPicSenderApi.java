package com.tencent.mobileqq.emosm.emocompat.impl;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.msgservice.k;
import com.tencent.guild.aio.sendmsg.SendMsgInterceptUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J:\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/emosm/emocompat/impl/GuildPicSenderApi;", "", "Lcom/tencent/aio/api/runtime/a;", "context", "", "path", "guildID", "channelID", "", QCircleLpReportDc010001.KEY_SUBTYPE, "", "isShowProcessDialog", "", "c", "result", "d", "", "e", "Lcom/tencent/aio/data/AIOSession;", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildPicSenderApi {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildPicSenderApi f204282a = new GuildPicSenderApi();

    GuildPicSenderApi() {
    }

    private final AIOSession b(String guildID, String channelID) {
        return new AIOSession(new AIOContact(4, channelID, guildID, null, 8, null));
    }

    @JvmStatic
    public static final void c(@NotNull com.tencent.aio.api.runtime.a context, @NotNull String path, @NotNull String guildID, @NotNull String channelID, int subType, boolean isShowProcessDialog) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(guildID, "guildID");
        Intrinsics.checkNotNullParameter(channelID, "channelID");
        QLog.i("GuildPicSenderApi", 4, "send MessageForPic==NT");
        if (fo0.b.c(context)) {
            QLog.i("GuildPicSenderApi", 4, "interceptOperationWhenInGuestInputMode");
            return;
        }
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("IS_SHOW_PROCESS_DIALOG", Boolean.valueOf(isShowProcessDialog)));
        SendMsgInterceptUtil sendMsgInterceptUtil = SendMsgInterceptUtil.f112285a;
        GuildPicSenderApi guildPicSenderApi = f204282a;
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(sendMsgInterceptUtil.a(new k(guildPicSenderApi.b(guildID, channelID), guildPicSenderApi.e(path, subType)), context, bundleOf), new GuildPicSenderApi$send$1(null)), Dispatchers.getMain()), GlobalScope.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(int result) {
        if (result == 100308) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f156871ld, 0).show();
        }
    }

    private final List<Object> e(String path, int subType) {
        return lp0.a.f415333a.b(path, true, subType);
    }
}
