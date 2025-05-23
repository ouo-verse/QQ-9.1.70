package com.tencent.mobileqq.guild.api;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH&\u00a2\u0006\u0002\u0010\fJf\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000b2B\u0010\u0012\u001a>\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000e0\u0013H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildAtNoticeApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAtNoticeFragment", "Landroidx/fragment/app/DialogFragment;", "guildId", "", "channelId", "liveRoomId", "", "atCount", "Lkotlin/Pair;", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkotlin/Pair;)Landroidx/fragment/app/DialogFragment;", "getNoticeConfig", "", "context", "Landroid/content/Context;", "scene", "openDialogCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "canOpenDialog", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGuildAtNoticeApi extends QRouteApi {
    @NotNull
    DialogFragment getAtNoticeFragment(@NotNull String guildId, @NotNull String channelId, @Nullable Long liveRoomId, @NotNull Pair<Integer, Integer> atCount);

    void getNoticeConfig(@Nullable Context context, @NotNull String guildId, int scene, @NotNull Function2<? super Boolean, ? super Pair<Integer, Integer>, Unit> openDialogCallback);
}
