package com.tencent.mobileqq.richmediabrowser.subtitle.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import vm2.SubtitleDisplayData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/richmediabrowser/subtitle/api/IDisplayVideoSubtitle;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lvm2/a;", "data", "", "start", "Companion", "a", "qq-richmediabrowser-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"peak"})
/* loaded from: classes18.dex */
public interface IDisplayVideoSubtitle extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f281882a;

    @NotNull
    public static final String TAG = "IDisplayVideoSubtitle";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/richmediabrowser/subtitle/api/IDisplayVideoSubtitle$a;", "", "<init>", "()V", "qq-richmediabrowser-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.richmediabrowser.subtitle.api.IDisplayVideoSubtitle$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f281882a = new Companion();

        Companion() {
        }
    }

    void start(@NotNull SubtitleDisplayData data);
}
