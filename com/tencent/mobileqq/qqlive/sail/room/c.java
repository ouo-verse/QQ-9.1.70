package com.tencent.mobileqq.qqlive.sail.room;

import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.anchor.AvConfig;
import com.tencent.mobileqq.qqlive.sail.model.anchor.SettingInfo;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JG\u0010\r\u001a\u00020\n2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u000221\u0010\f\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\b\u0012\u0004\u0012\u00020\u0006`\u000bH&J\u001c\u0010\u0012\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0013\u001a\u00020\u0006H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/c;", "Lcom/tencent/mobileqq/qqlive/sail/room/f;", "", "extBytes", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqlive/sail/room/l;", "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/mobileqq/qqlive/sail/room/Resulter;", "callback", "t", "Lcom/tencent/mobileqq/qqlive/sail/model/anchor/AvConfig;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/qqlive/sail/model/anchor/SettingInfo;", "info", "B", "b", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface c extends f {
    void B(@Nullable AvConfig config, @Nullable SettingInfo info);

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    @NotNull
    AnchorRoomInfo b();

    void t(@Nullable byte[] extBytes, @NotNull Function1<? super l<AnchorRoomInfo>, Unit> callback);
}
