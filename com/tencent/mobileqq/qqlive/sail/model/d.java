package com.tencent.mobileqq.qqlive.sail.model;

import com.tencent.mobileqq.qqlive.sail.model.common.UserInfo;
import cooperation.qzone.QZoneRequestEncoder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0004H&J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\r\u001a\u00020\u0002H&J\b\u0010\u000e\u001a\u00020\u0006H&J\b\u0010\u000f\u001a\u00020\u0004H&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/d;", "", "", "c", "", "getProgramId", "", "getRoomId", "", "getRoomType", "getRoomName", "Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;", "j", "g", "e", QZoneRequestEncoder.KEY_COVER_REQ, "f", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface d {
    boolean c();

    long e();

    @Nullable
    String f();

    boolean g();

    @NotNull
    String getCover();

    @NotNull
    String getProgramId();

    long getRoomId();

    @NotNull
    String getRoomName();

    int getRoomType();

    @Nullable
    UserInfo j();
}
